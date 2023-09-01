package com.seat.code.mower.application.useCase;

import com.seat.code.mower.domain.repositroy.IMowerRepository;
import com.seat.code.mower.domain.repositroy.MowerRepository;
import com.seat.code.mower.domain.service.MowerRunner;
import com.seat.code.mower.ports.*;
import com.seat.code.mower.ports.exception.OutOfPlateauBoundsException;
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
        DBService dbService = new com.seat.code.mower.adapters.DBService();
        MoveMowersUseCase useCase = getMoveMowersUseCase(dbService, validateInputCommands, reader);
        List<String> result = useCase.processCommandsMower(commands);
        assertEquals("1 3 N", result.get(0));
        assertEquals("5 1 E", result.get(1));

    }

    private static MoveMowersUseCase getMoveMowersUseCase(DBService dbService, ValidateInputCommands validateInputCommands, CommandReader reader) {
        IMowerRepository repository = new MowerRepository(dbService);
        MowerRunner runner = new MowerRunner(repository);
        InitializeMower initializeMower = new com.seat.code.mower.adapters.InitializeMower(validateInputCommands,runner);
        InitializePlateau initializePlateau = new com.seat.code.mower.adapters.InitializePlateau(validateInputCommands,runner);
        MoveMower moveMower = new com.seat.code.mower.adapters.MoveMower(validateInputCommands, runner);
        MoveMowersUseCase useCase =  new MoveMowersUseCase(initializeMower,initializePlateau,moveMower, reader);
        return useCase;
    }

    @Test
    void mowerInvalidCommandOutOfDimensionsShouldReturnException() {
        List<String> commands = Arrays.asList("5 5","1 2 N","LMLMLMLMM","3 3 E" , "MMRMMMMMRMRRM");
        ValidateInputCommands validateInputCommands= new com.seat.code.mower.adapters.ValidateInputCommands();
        CommandReader reader = new com.seat.code.mower.adapters.CommandReader(validateInputCommands);
        DBService dbService = new com.seat.code.mower.adapters.DBService();
        MoveMowersUseCase useCase = getMoveMowersUseCase(dbService, validateInputCommands, reader);
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