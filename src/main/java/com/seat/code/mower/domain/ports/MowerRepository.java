package com.seat.code.mower.domain.ports;

import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.domain.model.Plateau;

public interface MowerRepository {

    void  saveMowerState(Mower mover, Plateau plateau);

}
