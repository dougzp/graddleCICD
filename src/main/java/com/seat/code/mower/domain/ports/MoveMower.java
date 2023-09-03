package com.seat.code.mower.domain.ports;

import com.seat.code.mower.domain.model.Mower;

public interface MoveMower {

    public Mower moveMower(String commandMove, Mower mower) ;


}
