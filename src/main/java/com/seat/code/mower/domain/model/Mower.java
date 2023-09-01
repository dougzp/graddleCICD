package com.seat.code.mower.domain.model;

import java.util.UUID;

public final class Mower {

    public Mower(UUID uuid, Plateau plateau, Position initialPosition) {
        this.uuid = uuid;
        this.plateau = plateau;
        this.currentPosition = initialPosition;
    }

    public UUID getUuid() {
        return uuid;
    }

    private final UUID uuid;

    public Plateau getPlanteau() {
        return plateau;
    }

    private final Plateau plateau;


    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    private Position currentPosition;

}




