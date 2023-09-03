package com.seat.code.mower.adapters;

import com.seat.code.mower.adapters.exception.OutOfPlateauBoundsException;
import com.seat.code.mower.adapters.tos.MowerOrientation;
import com.seat.code.mower.adapters.tos.MowerPlateau;
import com.seat.code.mower.adapters.tos.MowerTos;
import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.domain.model.Orientation;
import com.seat.code.mower.domain.model.Plateau;
import com.seat.code.mower.domain.model.Position;
import com.seat.code.mower.domain.ports.ValidateInputCommands;
import com.seat.code.mower.adapters.tos.MowerPosition;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoveMower implements com.seat.code.mower.domain.ports.MoveMower {


    @Override
    public Mower moveMower(String commandMove, Mower mower) {

        MowerTos mowerTos = new MowerTos();
        mowerTos.setPosition(new MowerPosition(mower.getCurrentPosition().getPosInX(),mower.getCurrentPosition().getPosInY(), MowerOrientation.getByDegrees(mower.getCurrentPosition().getOrientation().getDegrees())));
        MowerPlateau mowerPlateau = new MowerPlateau(mower.getPlateau().getDimensionX(),mower.getPlateau().getDimensionY());
        mowerTos.setPlateau(mowerPlateau);
        IntStream charIntStream = commandMove.chars();
        Stream<Character> charStream = charIntStream.mapToObj(ch -> (char) ch);

        MowerTos finalMower = charStream.reduce(mowerTos, (m, c) -> {
            int newDegreesPosition = m.getPosition().getCurrentOrientation().getDegrees();
            int currentPositionX =  m.getPosition().getCurrentPositionX();
            int currentPositionY =  m.getPosition().getCurrentPositionY();

            switch (c) {
                case 'R' -> newDegreesPosition = (newDegreesPosition + 90) % 360;
                case 'L' -> newDegreesPosition = (newDegreesPosition - 90 + 360) % 360;
                case 'M' -> {
                    switch (newDegreesPosition) {
                        case 0, 360 -> currentPositionY++;
                        case 180 -> currentPositionY--;
                        case 90 -> currentPositionX++;
                        case 270 -> currentPositionX--;
                    }
                }
            }


           validateIfMowerPositionStillInsidePlateau(m.getPlateau(), currentPositionX, currentPositionY);
           MowerTos resultMower =  new MowerTos();
           resultMower.setUuid(m.getUuid());
           resultMower.setPlateau(m.getPlateau());
           MowerPosition resulPosition = new MowerPosition(currentPositionX,currentPositionY, MowerOrientation.getByDegrees(newDegreesPosition));
           resultMower.setPosition(resulPosition);
           return resultMower;
        }, (p1, p2) -> p2);

        Position currentPosition = new Position(finalMower.getPosition().getCurrentPositionX(),finalMower.getPosition().getCurrentPositionY(), Orientation.getByDegrees(finalMower.getPosition().getCurrentOrientation().getDegrees()));
        Plateau plateau = new Plateau(finalMower.getPlateau().getDimensionX(), mowerTos.getPlateau().getDimensionY());
        Mower resultMower = new Mower(finalMower.getUuid(), plateau);
        resultMower.setCurrentPosition(currentPosition);
        return resultMower;

    }

    protected void validateIfMowerPositionStillInsidePlateau(MowerPlateau plateau, int currentPositionX, int currentPositionY) {
        if (currentPositionX < 0 || currentPositionX > plateau.getDimensionX() ||
                currentPositionY < 0 || currentPositionY > plateau.getDimensionY()) {
            throw new OutOfPlateauBoundsException("The mower is out of the plateau's bounds!");
        }
    }
}
