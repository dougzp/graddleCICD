package com.seat.code.mower.adapters.tos;

import java.util.UUID;

public class MowerTos {
    private UUID uuid;
    private MowerPosition position;

    private MowerPlateau plateau;

    public MowerPlateau getPlateau() {
        return plateau;
    }

    public void setPlateau(MowerPlateau plateau) {
        this.plateau = plateau;
    }

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public MowerPosition getPosition() {
        return position;
    }

    public void setPosition(MowerPosition position) {
        this.position = position;
    }

}
