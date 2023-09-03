package com.seat.code.mower.adapters;

import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.domain.model.Orientation;
import com.seat.code.mower.domain.model.Plateau;
import com.seat.code.mower.domain.model.Position;
import com.seat.code.mower.adapters.tos.MowerOrientation;

import java.util.UUID;

public class InitializeMower implements com.seat.code.mower.domain.ports.InitializeMower {
    public static final String SPACE = " ";


    @Override
    public Mower initializeMowerPosition(Plateau plateau, String moverInitCommand) {

        String[] mowerCommand = moverInitCommand.trim().split(SPACE);
        int initialPositionX =  Integer.parseInt(mowerCommand[0]);
        int initialPositionY =  Integer.parseInt(mowerCommand[1]);

        MowerOrientation mowerOrientation = MowerOrientation.getByString(mowerCommand[2]);

        Position initialPosition = new Position(initialPositionX,initialPositionY, Orientation.getByDegrees(mowerOrientation.getDegrees()));
        Mower mower  = new Mower(UUID.randomUUID(),plateau);
        mower.setCurrentPosition(initialPosition);
        return mower;
    }


}