package com.seat.code.mower.domain.ports;

import java.util.function.Predicate;

public interface ValidateInputCommands {

    Character validateAndNormalizeInputOrientationCommand(Character input);
    Predicate<String> validatePlateauInitCommand();

    Predicate<String> validateMowerInitCommand();

    Predicate<String> validateMowerMoveCommand();
}
