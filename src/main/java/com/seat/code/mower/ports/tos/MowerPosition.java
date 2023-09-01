package com.seat.code.mower.ports.tos;

import com.seat.code.mower.domain.model.Orientation;

import java.util.Objects;

public final class MowerPosition {


    private final int currentPositionX;
    private final int currentPositionY;

    private final MowerOrientation currentOrientation;
    private final MowerPlateau plateau;


    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public int getCurrentPositionY() {
        return currentPositionY;
    }

    public MowerOrientation getCurrentOrientation() {
        return currentOrientation;
    }
    public MowerPlateau getPlateau() { return plateau; }

    public MowerPosition(int currentPositionX, int currentPositionY, MowerOrientation currentOrientation, MowerPlateau plateau) {
        this.currentPositionX = currentPositionX;
        this.currentPositionY = currentPositionY;
        this.currentOrientation = currentOrientation;
        this.plateau = plateau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MowerPosition that = (MowerPosition) o;
        return currentPositionX == that.currentPositionX && currentPositionY == that.currentPositionY && currentOrientation == that.currentOrientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPositionX, currentPositionY, currentOrientation);
    }

    @Override
    public String toString() {
        return "MowerPosition{" +
                "currentPositionX=" + currentPositionX +
                ", currentPositionY=" + currentPositionY +
                ", currentOrientation=" + currentOrientation +
                ", plateau=" + plateau +
                '}';
    }
}
