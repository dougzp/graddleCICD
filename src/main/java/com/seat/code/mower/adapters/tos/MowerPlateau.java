package com.seat.code.mower.adapters.tos;

import com.seat.code.mower.domain.model.Plateau;

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

    public Plateau ToDomain(){
      return new Plateau(this.getDimensionX(),this.getDimensionY());
    }
}
