package com.seat.code.mower.adapters;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidateInputCommands implements com.seat.code.mower.domain.ports.ValidateInputCommands {
    @Override
    public Character validateAndNormalizeInputOrientationCommand(Character input) {
        Predicate<Character> validLetterPredicate = c -> "NSWE".indexOf(Character.toUpperCase(c)) != -1;
        if (!validLetterPredicate.test(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        return Character.toUpperCase(input);
    }

    public Predicate<String> validatePlateauInitCommand() {
        return Pattern.compile("^\\d+ \\d+$").asPredicate();
    }

    public Predicate<String> validateMowerInitCommand() {
        return Pattern.compile("^\\d+ \\d+ [A-Za-z]$").asPredicate();
    }
    public Predicate<String> validateMowerMoveCommand() {
        return Pattern.compile("^[LRM]+$").asPredicate();
    }


}
