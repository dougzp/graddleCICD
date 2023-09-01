package com.seat.code.mower.adapters;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidateInputCommands implements com.seat.code.mower.ports.ValidateInputCommands {
    @Override
    public Character validateAndNormalizeInputOrientationCommand(Character input) {
        Predicate<Character> validLetterPredicate = c -> "NSWE".indexOf(Character.toUpperCase(c)) != -1;
        if (!validLetterPredicate.test(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        return Character.toUpperCase(input);
    }

    public Boolean validatePlateauInitCommand(String input) {
        Predicate<String> isTwoNumbers = Pattern.compile("^\\d+ \\d+$").asPredicate();
        return isTwoNumbers.test(input);
    }

    public Boolean validateMowerInitCommand(String input) {
        Predicate<String> isTwoNumbersAndALetter = Pattern.compile("^\\d+ \\d+ [A-Za-z]$").asPredicate();
        return isTwoNumbersAndALetter.test(input);
    }
    public Boolean validateMowerMoveCommand(String input) {
        Predicate<String> onlyLRM = Pattern.compile("^[LRM]+$").asPredicate();
        return onlyLRM.test(input);
    }


}
