package com.seat.code.mower.adapters;

import com.seat.code.mower.domain.service.IMowerRunner;
import com.seat.code.mower.ports.ValidateInputCommands;
import com.seat.code.mower.ports.tos.MowerPlateau;

import static com.seat.code.mower.Main.SPACE;

public class InitializePlateau implements com.seat.code.mower.ports.InitializePlateau {


    private final ValidateInputCommands validator;
    private final IMowerRunner runner;

    public InitializePlateau(ValidateInputCommands validator, IMowerRunner runner) {
        this.validator = validator;
        this.runner = runner;
    }

    @Override
    public MowerPlateau createPlateau(String plateauInitCommand) {
       if(!this.validator.validatePlateauInitCommand(plateauInitCommand)){
           return null;
       }
        String[] plateauCommand = plateauInitCommand.trim().split(SPACE);
        int dimensionX =  Integer.parseInt(plateauCommand[0]);
        int dimensionY =  Integer.parseInt(plateauCommand[1]);
        return new MowerPlateau(dimensionX,dimensionY);

    }
}
