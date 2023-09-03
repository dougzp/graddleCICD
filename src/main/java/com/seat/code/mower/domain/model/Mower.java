package com.seat.code.mower.domain.model;

import java.util.UUID;

public final class Mower {

    public Mower(UUID uuid, Plateau plateau) {
        this.uuid = uuid;
        this.plateau = plateau;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private UUID uuid;
    private final Plateau plateau;
    private Position currentPosition;

    public Plateau getPlateau() {
        return plateau;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }



}




