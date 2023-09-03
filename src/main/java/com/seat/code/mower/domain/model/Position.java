package com.seat.code.mower.domain.model;

public final class Position {

    public Position(int posInX, int posInY, Orientation orientation) {
        //validar posiciones sean positivos
        this.posInX = posInX;
        this.posInY = posInY;
        this.orientation = orientation;

    }
    private final int posInX;

    private final int posInY;

    private final Orientation orientation;


    public Orientation getOrientation() {
        return orientation;
    }

    public int getPosInX() {
        return posInX;
    }
    public int getPosInY() {
        return posInY;
    }


}
