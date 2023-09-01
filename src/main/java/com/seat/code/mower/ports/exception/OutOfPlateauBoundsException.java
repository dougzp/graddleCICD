package com.seat.code.mower.ports.exception;

public class OutOfPlateauBoundsException extends RuntimeException {
    public OutOfPlateauBoundsException(String message) {
        super(message);
    }
}