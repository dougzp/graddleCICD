package com.seat.code.mower.adapters;

import com.seat.code.mower.domain.service.IMowerRunner;
import com.seat.code.mower.ports.ValidateInputCommands;
import com.seat.code.mower.ports.tos.MowerPosition;

public class MoveMower implements com.seat.code.mower.ports.MoveMower {

    private final ValidateInputCommands validator;
    private final IMowerRunner runner;

    public MoveMower(ValidateInputCommands validator, IMowerRunner runner) {
        this.validator = validator;
        this.runner = runner;
    }

    @Override
    public MowerPosition moveMower(String commandMove,MowerPosition position) {
        if(!this.validator.validateMowerMoveCommand(commandMove)){
            return null;
        }
        return this.runner.moveMower(commandMove,position);
    }
}
