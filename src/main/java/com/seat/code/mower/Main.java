package com.seat.code.mower;

import com.seat.code.mower.domain.ports.ValidateInputCommands;
import com.seat.code.mower.adapters.tos.MowerOrientation;

import java.util.Scanner;


public class Main {

    public static final String SPACE = " ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initPlateau = scanner.nextLine();
        ValidateInputCommands validator = new com.seat.code.mower.adapters.ValidateInputCommands();

        String initMower = scanner.nextLine();
        String[] moverInitCommand = initMower.split(SPACE);
        int mowerPositionX= Integer.parseInt(moverInitCommand[0]);
        int mowerPositionY= Integer.parseInt(moverInitCommand[1]);
        Character moverStringOrientation = validator.validateAndNormalizeInputOrientationCommand(moverInitCommand[2].charAt(0));
        MowerOrientation orientation = MowerOrientation.valueOf(moverStringOrientation.toString());

        System.out.println(orientation);

    }
}

