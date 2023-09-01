package com.seat.code.mower.ports.tos;

public class MowerPlateau {

    public MowerPlateau(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    private final int dimensionX;
    private final int dimensionY;

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }
}
