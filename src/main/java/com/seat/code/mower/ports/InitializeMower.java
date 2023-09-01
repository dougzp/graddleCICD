package com.seat.code.mower.ports;


import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;

public interface InitializeMower {

    MowerPosition initializeMowerPosition(MowerPlateau plateau, String moverInitCommand);


}
