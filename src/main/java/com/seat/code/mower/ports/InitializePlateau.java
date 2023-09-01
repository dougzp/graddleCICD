package com.seat.code.mower.ports;

import com.seat.code.mower.ports.tos.MowerPlateau;

public interface InitializePlateau {

    MowerPlateau createPlateau(String plateauInitCommand);
}
