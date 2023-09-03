package com.seat.code.mower.adapters.exception;

public class InvalidMowerCommandException extends RuntimeException {
    public InvalidMowerCommandException(String message) {
        super(message);
    }
}