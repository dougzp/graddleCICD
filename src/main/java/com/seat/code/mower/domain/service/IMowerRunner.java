package com.seat.code.mower.domain.service;

import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.ports.tos.MowerOrientation;
import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;

public interface IMowerRunner {

    MowerPosition initializePlateauAndMower(int currentPositionX, int currentPositionY, MowerOrientation orientation, MowerPlateau mowerPlateau);
    MowerPosition moveMower(String commandMove,MowerPosition position);
    void saveMowerState(Mower mower);
}
