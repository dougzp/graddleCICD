package com.seat.code.mower.domain.model;

public final class Position {

    public Position(int posInX, int currentPositionY, Orientation orientation) {
        this.posInX = posInX;
        this.posInY = currentPositionY;
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
