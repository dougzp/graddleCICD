package com.seat.code.mower.application.useCase;

import com.seat.code.mower.ports.CommandReader;
import com.seat.code.mower.ports.InitializeMower;
import com.seat.code.mower.ports.InitializePlateau;
import com.seat.code.mower.ports.MoveMower;
import com.seat.code.mower.ports.tos.MowerCommands;
import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MoveMowersUseCase {
    private final InitializeMower initializeMower;
    private final InitializePlateau initializePlateau;

    private final MoveMower moveMower;
    private final CommandReader commandReader;

    public MoveMowersUseCase(InitializeMower initializeMower, InitializePlateau initializePlateau, MoveMower moveMower, CommandReader commandReader) {
        this.initializeMower = initializeMower;
        this.initializePlateau = initializePlateau;
        this.moveMower = moveMower;
        this.commandReader = commandReader;
    }

    private static class ProcessingState {
        MowerPlateau plateau = null;
        MowerPosition position = null;
        List<String> resultMoves = new ArrayList<>();
    }

    public List<String> processCommandsMower(List<String> commmands) {
        List<MowerCommands> mowerCommands = this.commandReader.readMowerCommandsToProcess(commmands);
        return mowerCommands.stream()
                .reduce(new ProcessingState(), (state, command) -> {
                    switch (command.getType()) {
                        case PLATEAU_INIT:
                            if (state.plateau != null) {
                                throw new IllegalStateException("Plateau is already initialized.");
                            }
                            state.plateau = this.initializePlateau.createPlateau(command.getCommand());
                            break;
                        case MOWER_INIT:
                            if (state.plateau == null) {
                                throw new IllegalStateException("Plateau has not been initialized.");
                            }

                            state.position = this.initializeMower.initializeMowerPosition(state.plateau, command.getCommand());
                            break;
                        case MOVER_MOVE:
                            if (state.position == null) {
                                throw new IllegalStateException("Mower has not been initialized.");
                            }
                            state.position = this.moveMower.moveMower(command.getCommand(), state.position);
                            state.resultMoves.add(state.position.getCurrentPositionX() + " " + state.position.getCurrentPositionY() + " " + state.position.getCurrentOrientation().toString());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid command type: " + command.getType());
                    }
                    return state;
                }, (s1, s2) -> { throw new UnsupportedOperationException("Combining not supported in sequential stream"); })
                .resultMoves;

    }
}
