package com.seat.code.mower.adapters.tos;

import java.util.Objects;
import java.util.UUID;

public final class MowerPosition {


    private final int currentPositionX;
    private final int currentPositionY;

    private final MowerOrientation currentOrientation;

    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public int getCurrentPositionY() {
        return currentPositionY;
    }

    public MowerOrientation getCurrentOrientation() {
        return currentOrientation;
    }

    public MowerPosition(int currentPositionX, int currentPositionY, MowerOrientation currentOrientation) {
        this.currentPositionX = currentPositionX;
        this.currentPositionY = currentPositionY;
        this.currentOrientation = currentOrientation;

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
                '}';
    }
}
