package com.seat.code.mower;

import com.seat.code.mower.ports.ValidateInputCommands;
import com.seat.code.mower.ports.tos.MowerOrientation;
import com.seat.code.mower.ports.tos.MowerPosition;

import java.util.Scanner;


public class Main {

    public static final String SPACE = " ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initPlateau = scanner.nextLine();
        ValidateInputCommands validator = new com.seat.code.mower.adapters.ValidateInputCommands();
        Boolean isValidPlateauInitCommand = validator.validatePlateauInitCommand(initPlateau);
        if(!isValidPlateauInitCommand){
            System.out.println("Invalid Plateau initialization, value should be compose by 2 Integers like : 5 5");
        }

        String initMower = scanner.nextLine();
        Boolean isValidMowerInitCommand = validator.validateMowerInitCommand(initMower);
        String[] moverInitCommand = initMower.split(SPACE);
        int mowerPositionX= Integer.parseInt(moverInitCommand[0]);
        int mowerPositionY= Integer.parseInt(moverInitCommand[1]);
        Character moverStringOrientation = validator.validateAndNormalizeInputOrientationCommand(moverInitCommand[2].charAt(0));
        MowerOrientation orientation = MowerOrientation.valueOf(moverStringOrientation.toString());

        System.out.println(orientation);

    }
}

