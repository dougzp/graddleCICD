package com.seat.code.mower.domain.ports;


import com.seat.code.mower.domain.model.Plateau;

public interface InitializePlateau {

   Plateau createPlateau(String plateauInitCommand);
}
