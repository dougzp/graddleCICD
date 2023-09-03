package com.seat.code.mower.adapters.tos;

public enum MowerOrientation {

    N(0),
    S(180),
    E(90),
    W(270);

    public int getDegrees() {
        return degrees;
    }

    private final int degrees;

    MowerOrientation(int degrees) {
        this.degrees = degrees;
    }

    public static MowerOrientation getByDegrees(int degrees) {
        for (MowerOrientation orientation : values()) {
            if (orientation.degrees == degrees) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("No orientation found for degrees: " + degrees);
    }

    public static MowerOrientation getByString(String value) {

        for (MowerOrientation orientation : values()) {
            if (orientation.name().equalsIgnoreCase(value)) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("No orientation found for value: " + value);
    }

}
