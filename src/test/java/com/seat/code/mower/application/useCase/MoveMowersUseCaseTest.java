package com.seat.code.mower.application.useCase;

import com.seat.code.mower.adapters.exception.InvalidMowerCommandException;
import com.seat.code.mower.domain.ports.*;
import com.seat.code.mower.adapters.exception.OutOfPlateauBoundsException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveMowersUseCaseTest {


    @Test
    void moveMower() {
        List<String> commands = Arrays.asList("5 5","1 2 N","LMLMLMLMM","3 3 E" , "MMRMMRMRRM");
        ValidateInputCommands validateInputCommands= new com.seat.code.mower.adapters.ValidateInputCommands();
        CommandReader reader = new com.seat.code.mower.adapters.CommandReader(validateInputCommands);
        MoveMowersUseCase useCase = getMoveMowersUseCase(validateInputCommands, reader);
        List<String> result = useCase.processCommandsMower(commands);
        assertEquals("1 3 N", result.get(0));
        assertEquals("5 1 E", result.get(1));

    }

    @Test
    void moveMowerInvalidCommand() {
        List<String> commands = Arrays.asList("5 5","1 2 N","LPMLMLMLMM","3 3 E" , "MMRMMRMRRM");
        ValidateInputCommands validateInputCommands= new com.seat.code.mower.adapters.ValidateInputCommands();
        CommandReader reader = new com.seat.code.mower.adapters.CommandReader(validateInputCommands);
        MoveMowersUseCase useCase = getMoveMowersUseCase(validateInputCommands, reader);
        InvalidMowerCommandException thrown = assertThrows(
                InvalidMowerCommandException.class,
                () -> {
                    List<String> result = useCase.processCommandsMower(commands);
                    System.out.println(result);
                },
                "Expected moveMower() to throw InvalidMowerCommandException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Invalid List of Commands"));

    }

    private static MoveMowersUseCase getMoveMowersUseCase(ValidateInputCommands validateInputCommands, CommandReader reader) {

        InitializeMower initializeMower = new com.seat.code.mower.adapters.InitializeMower();
        InitializePlateau initializePlateau = new com.seat.code.mower.adapters.InitializePlateau();
        MoveMower moveMower = new com.seat.code.mower.adapters.MoveMower();
        MowerRepository repository = new com.seat.code.mower.adapters.MowerRepository();
        return new MoveMowersUseCase(initializeMower,initializePlateau,moveMower, reader,validateInputCommands, repository);
    }

    @Test
    void mowerInvalidCommandOutOfDimensionsShouldReturnException() {
        List<String> commands = Arrays.asList("5 5","1 2 N","LMLMLMLMM","3 3 E" , "MMRMMMMMRMRRM");
        ValidateInputCommands validateInputCommands= new com.seat.code.mower.adapters.ValidateInputCommands();
        CommandReader reader = new com.seat.code.mower.adapters.CommandReader(validateInputCommands);
        MoveMowersUseCase useCase = getMoveMowersUseCase( validateInputCommands, reader);
        OutOfPlateauBoundsException thrown = assertThrows(
                OutOfPlateauBoundsException.class,
                () -> {
                    List<String> result = useCase.processCommandsMower(commands);
                    System.out.println(result);
                },
                "Expected moveMower() to throw OutOfPlateauBoundsException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("The mower is out of the plateau's bounds!"));



    }


}