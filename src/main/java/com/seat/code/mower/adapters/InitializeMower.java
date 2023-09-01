package com.seat.code.mower.adapters;

import com.seat.code.mower.domain.service.IMowerRunner;
import com.seat.code.mower.ports.ValidateInputCommands;
import com.seat.code.mower.ports.tos.MowerOrientation;
import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;

public class InitializeMower implements com.seat.code.mower.ports.InitializeMower {
    public static final String SPACE = " ";
    private final ValidateInputCommands validator;
    private final IMowerRunner runner;
    public InitializeMower(ValidateInputCommands validator, IMowerRunner runner) {
        this.validator = validator;
        this.runner = runner;
    }

    @Override
    public MowerPosition initializeMowerPosition(MowerPlateau plateau, String moverInitCommand) {

        if(!this.validator.validateMowerInitCommand(moverInitCommand)) {
            return null;
        }

        String[] mowerCommand = moverInitCommand.trim().split(SPACE);
        int initialPositionX =  Integer.parseInt(mowerCommand[0]);
        int initialPositionY =  Integer.parseInt(mowerCommand[1]);

        MowerOrientation mowerOrientation = MowerOrientation.getByString(mowerCommand[2]);

        return  runner.initializePlateauAndMower(initialPositionX,initialPositionY,mowerOrientation,plateau);
    }


}