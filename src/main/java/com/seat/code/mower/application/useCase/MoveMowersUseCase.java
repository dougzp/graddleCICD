package com.seat.code.mower.application.useCase;

import com.seat.code.mower.adapters.exception.InvalidMowerCommandException;
import com.seat.code.mower.adapters.tos.MowerCommands;
import com.seat.code.mower.domain.model.*;
import com.seat.code.mower.domain.ports.*;


import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;


public class MoveMowersUseCase {
    private final InitializeMower initializeMower;
    private final InitializePlateau initializePlateau;

    private final MoveMower moveMower;
    private final CommandReader commandReader;

    private final ValidateInputCommands validateInputCommands;

    private final MowerRepository repository;

    public MoveMowersUseCase(InitializeMower initializeMower, InitializePlateau initializePlateau, MoveMower moveMower, CommandReader commandReader, ValidateInputCommands validateInputCommands, MowerRepository repository) {
        this.initializeMower = initializeMower;
        this.initializePlateau = initializePlateau;
        this.moveMower = moveMower;
        this.commandReader = commandReader;
        this.validateInputCommands = validateInputCommands;
        this.repository = repository;
    }


    public List<String> processCommandsMower(List<String> commands) {
        List<MowerCommands> mowerCommands = this.commandReader.readMowerCommandsToProcess(commands);
        return mowerCommands.stream()
                .reduce(new ProcessingState(), (state, command) -> {
                    switch (command.getType()) {
                        case PLATEAU_INIT -> {
                            if (state.getMower()!=null && state.getMower().getPlateau() != null) {
                                throw new IllegalStateException("Plateau is already initialized.");
                            }
                            validateCommand(command,this.validateInputCommands.validatePlateauInitCommand());
                            Plateau plateau = this.initializePlateau.createPlateau(command.getCommand());
                            Mower mower = new Mower(UUID.randomUUID(),plateau);
                            state.setMower(mower);
                        }
                        case MOWER_INIT -> {
                            if (state.getMower().getPlateau() == null) {
                                throw new IllegalStateException("Plateau has not been initialized.");
                            }
                            validateCommand(command,this.validateInputCommands.validateMowerInitCommand());
                            state.setMower(this.initializeMower.initializeMowerPosition(state.getMower().getPlateau(), command.getCommand()));
                            saveMowerStatePosition(state);
                        }
                        case MOVER_MOVE -> {
                            if (state.getMower() == null) {
                                throw new IllegalStateException("Mower has not been initialized.");
                            }
                            validateCommand(command, this.validateInputCommands.validateMowerMoveCommand());
                            state.setMower(this.moveMower.moveMower(command.getCommand(), state.getMower()));
                            state.getResultMoves().add(state.getMower().getCurrentPosition().getPosInX() + " " + state.getMower().getCurrentPosition().getPosInY() + " " + state.getMower().getCurrentPosition().getOrientation().toString());
                            saveMowerStatePosition(state);
                        }
                        default -> throw new IllegalArgumentException("Invalid command type: " + command.getType());
                    }
                    return state;
                }, (s1, s2) -> { throw new UnsupportedOperationException("Combining not supported in sequential stream"); })
                .getResultMoves();

    }

    private void validateCommand(MowerCommands command, Predicate<String> validationPredicate) {
        boolean validCommand = validationPredicate.test(command.getCommand());
        if(!validCommand){
            throw new InvalidMowerCommandException("Invalid "+command.getType()+" command");
        }
    }

    protected void saveMowerStatePosition(ProcessingState state) {

        this.repository.saveMowerState(state.getMower(),state.getMower().getPlateau());

    }
}
