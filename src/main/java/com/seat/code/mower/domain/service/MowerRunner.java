package com.seat.code.mower.domain.service;

import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.domain.model.Orientation;
import com.seat.code.mower.domain.model.Plateau;
import com.seat.code.mower.domain.model.Position;
import com.seat.code.mower.domain.repositroy.IMowerRepository;
import com.seat.code.mower.ports.tos.MowerOrientation;
import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;

import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MowerRunner implements IMowerRunner {

    private final IMowerRepository repository;

    public MowerRunner(IMowerRepository repository) {
        this.repository = repository;
    }

    @Override
    public MowerPosition initializePlateauAndMower(int currentPositionX, int currentPositionY, MowerOrientation orientation,  MowerPlateau mowerPlateau) {
        Plateau plateau = new Plateau(mowerPlateau.getDimensionX(), mowerPlateau.getDimensionY());
        Position initialPosition = new Position(currentPositionX,currentPositionY, Orientation.getByDegrees(orientation.getDegrees()));
        Mower mower  = new Mower(UUID.randomUUID(),plateau,initialPosition);
        return new MowerPosition(mower.getCurrentPosition().getPosInX()
        ,mower.getCurrentPosition().getPosInY(), orientation, mowerPlateau);
    }

    public MowerPosition moveMower(String commandMove, MowerPosition position) {
        IntStream charIntStream = commandMove.chars();
        Stream<Character> charStream = charIntStream.mapToObj(ch -> (char) ch);

        return charStream.reduce(position, (currentPos, c) -> {
            int newDegreesPosition = currentPos.getCurrentOrientation().getDegrees();
            int currentPositionX = currentPos.getCurrentPositionX();
            int currentPositionY = currentPos.getCurrentPositionY();

            switch (c) {
                case 'R':
                    newDegreesPosition = (newDegreesPosition + 90) % 360;
                    break;
                case 'L':
                    newDegreesPosition = (newDegreesPosition - 90 + 360) % 360;
                    break;
                case 'M':
                    switch (newDegreesPosition) {
                        case 0:
                        case 360:
                            currentPositionY++;
                            break;
                        case 180:
                            currentPositionY--;
                            break;
                        case 90:
                            currentPositionX++;
                            break;
                        case 270:
                            currentPositionX--;
                            break;
                    }
                    break;
            }
            return new MowerPosition(currentPositionX, currentPositionY, MowerOrientation.getByDegrees(newDegreesPosition), currentPos.getPlateau());
        }, (p1, p2) -> p2); // This combiner function is required by reduce method but is not used in sequential streams.
    }

    @Override
    public void saveMowerState(Mower mower) {
        this.repository.savaMowerState(mower);
    }
}
