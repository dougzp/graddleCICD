package com.seat.code.mower.adapters;

import com.seat.code.mower.ports.tos.MowerPosition;
import com.seat.code.mower.ports.tos.MowerTos;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DBService implements com.seat.code.mower.ports.DBService{

    private final Map<UUID, MowerPosition> map = new HashMap<>();

    @Override
    public void saveMower(MowerTos mowerTos) {
        map.put(mowerTos.getUuid(),mowerTos.getPosition());
    }
}
