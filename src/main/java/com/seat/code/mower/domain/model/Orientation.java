package com.seat.code.mower.domain.model;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public enum Orientation {
    N(0),
    S(180),
    E(90),
    W(270);

    public int getDegrees() {
        return degrees;
    }

    private final int degrees;

    Orientation(int degrees) {
        this.degrees = degrees;
    }

    public static Orientation getByDegrees(int degrees) {
        for (Orientation orientation : values()) {
            if (orientation.degrees == degrees) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("No orientation found for degrees: " + degrees);
    }
}
