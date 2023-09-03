package com.seat.code.mower.domain.model;

public final class Plateau {

    public Plateau(int dimensionX, int dimensionY) {
        //validar dimensiones mayores que 0
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
