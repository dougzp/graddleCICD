package com.seat.code.mower.domain.model;


import java.util.ArrayList;
import java.util.List;

public class ProcessingState {

    Mower mower = null;
    List<String> resultMoves = new ArrayList<>();


    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public List<String> getResultMoves() {
        return resultMoves;
    }





}
