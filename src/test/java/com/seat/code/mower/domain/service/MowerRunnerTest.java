package com.seat.code.mower.domain.service;

import com.seat.code.mower.domain.repositroy.IMowerRepository;
import com.seat.code.mower.domain.repositroy.MowerRepository;
import com.seat.code.mower.ports.DBService;
import com.seat.code.mower.ports.tos.MowerOrientation;
import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerRunnerTest {


    @Test
    void initializePlateauAndMower() {

        MowerPosition mowerPosition = getMowerPosition();
        assertEquals(1, mowerPosition.getCurrentPositionX());
        assertEquals(2, mowerPosition.getCurrentPositionY());
        assertEquals(MowerOrientation.N, mowerPosition.getCurrentOrientation());
        assertEquals(5, mowerPosition.getPlateau().getDimensionX());
        assertEquals(5, mowerPosition.getPlateau().getDimensionY());
    }

    @Test
    void moveMowerTestCase1() {
        DBService dbService = new com.seat.code.mower.adapters.DBService();
        IMowerRepository repository = new MowerRepository(dbService);
        IMowerRunner runner = new MowerRunner(repository);
        MowerPosition mowerPosition = getMowerPosition();
        MowerPosition position = runner.moveMower("LMLMLMLMM", mowerPosition);
        assertEquals(1, position.getCurrentPositionX());
        assertEquals(3, position.getCurrentPositionY());
        assertEquals(MowerOrientation.N, position.getCurrentOrientation());
    }

    private static MowerPosition getMowerPosition() {

        int initialPositionX = 1;
        int initialPositionY = 2;

        int dimensionX = 5;
        int dimensionY = 5;
        MowerPlateau mowerPlateau = new MowerPlateau(dimensionX,dimensionY);
        return new MowerPosition(initialPositionX,initialPositionY,MowerOrientation.N,mowerPlateau);
    }


}