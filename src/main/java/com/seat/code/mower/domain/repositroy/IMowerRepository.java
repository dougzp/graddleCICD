package com.seat.code.mower.domain.repositroy;

import com.seat.code.mower.domain.model.Mower;

public interface IMowerRepository {

    void savaMowerState(Mower mover);

}
