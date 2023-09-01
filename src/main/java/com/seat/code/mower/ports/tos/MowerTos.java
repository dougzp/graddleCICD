package com.seat.code.mower.ports.tos;

import java.util.UUID;

public class MowerTos {
    private UUID uuid;
    private MowerPosition position;
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
