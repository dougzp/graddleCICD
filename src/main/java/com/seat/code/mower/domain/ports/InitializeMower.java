package com.seat.code.mower.domain.ports;


import com.seat.code.mower.adapters.tos.MowerPlateau;
import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.domain.model.Plateau;

public interface InitializeMower {

    Mower initializeMowerPosition(Plateau plateau, String moverInitCommand);


}
