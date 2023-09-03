package com.seat.code.mower.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    @Test
    void when_create_new_mover_should_return_constructor_values() {
        // given
        Plateau plateau =  new Plateau(5,10);
        UUID uuid = UUID.randomUUID();
        Position initialPosition = new Position(1,2, Orientation.N);

        Mower mower  = new Mower(uuid, plateau);
        mower.setCurrentPosition(initialPosition);
        // then
        assertEquals(uuid, mower.getUuid());
        assertEquals(plateau, mower.getPlateau());
        assertEquals(initialPosition, mower.getCurrentPosition());

    }

    @Test
    void when_create_new_initial_position_should_return_constructor_values() {
        // given
        int initialPositionX = 3;
        int initialPositionY = 4;
        Orientation initialOrientation = Orientation.N;

        // when
        Position initialPosition =  new Position(initialPositionX,initialPositionY,initialOrientation);

        // then
        assertEquals(initialPositionX,initialPosition.getPosInX());
        assertEquals(initialPositionY,initialPosition.getPosInY());
        assertEquals(initialOrientation,initialPosition.getOrientation());


    }


    @Test
    void when_mower_moves_should_return_new_current_position_on_values() {

        // given
        Plateau plateau =  new Plateau(5,10);
        UUID uuid = UUID.randomUUID();
        Position initialPosition = new Position(1,2, Orientation.N);
        Mower mower = new Mower(uuid, plateau );
        mower.setCurrentPosition(initialPosition);
        int newPositionX=2;
        int newPositionY=1;
        Orientation newOrientation=Orientation.S;
        Position newPosition =  new Position(newPositionX,newPositionY,newOrientation);

        // when
        mower.setCurrentPosition(newPosition);


        // then
        assertEquals(newPositionX,mower.getCurrentPosition().getPosInX());
        assertEquals(newPositionY,mower.getCurrentPosition().getPosInY());
        assertEquals(newOrientation,mower.getCurrentPosition().getOrientation());


    }

    @Test
    void when_create_new_plateau_should_return_constructor_values() {
        // given
        int dimensionX = 5;
        int dimensionY = 10;

        // when
        Plateau plateau =  new Plateau(dimensionX,dimensionY);

        // then
        assertEquals(dimensionX, plateau.getDimensionX());
        assertEquals(dimensionY, plateau.getDimensionY());



    }

}