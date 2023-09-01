package com.seat.code.mower.domain.model;

public final class Plateau {

    public Plateau(int dimensionX, int dimensionY) {
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
