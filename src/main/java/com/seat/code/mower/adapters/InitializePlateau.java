package com.seat.code.mower.adapters;

import com.seat.code.mower.domain.model.Plateau;
import com.seat.code.mower.domain.ports.ValidateInputCommands;
import com.seat.code.mower.adapters.tos.MowerPlateau;

import static com.seat.code.mower.Main.SPACE;

public class InitializePlateau implements com.seat.code.mower.domain.ports.InitializePlateau {


    @Override
    public Plateau createPlateau(String plateauInitCommand) {
        String[] plateauCommand = plateauInitCommand.trim().split(SPACE);
        int dimensionX =  Integer.parseInt(plateauCommand[0]);
        int dimensionY =  Integer.parseInt(plateauCommand[1]);
        return new MowerPlateau(dimensionX,dimensionY).ToDomain();

    }
}
