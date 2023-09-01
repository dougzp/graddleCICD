package com.seat.code.mower.ports;

import com.seat.code.mower.domain.model.Orientation;
import com.seat.code.mower.domain.model.Position;
import com.seat.code.mower.ports.tos.MowerPosition;

public interface MoveMower {

    MowerPosition moveMower(String commandMove, MowerPosition position);


}
