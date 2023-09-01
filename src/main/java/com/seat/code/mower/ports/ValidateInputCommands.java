package com.seat.code.mower.ports;

public interface ValidateInputCommands {

    Character validateAndNormalizeInputOrientationCommand(Character input);
    Boolean validatePlateauInitCommand(String input);

    Boolean validateMowerInitCommand(String input);

    Boolean validateMowerMoveCommand(String input);
}
