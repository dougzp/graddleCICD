package com.seat.code.mower.domain.repositroy;

import com.seat.code.mower.domain.model.Mower;
import com.seat.code.mower.ports.DBService;
import com.seat.code.mower.ports.tos.MowerOrientation;
import com.seat.code.mower.ports.tos.MowerPlateau;
import com.seat.code.mower.ports.tos.MowerPosition;
import com.seat.code.mower.ports.tos.MowerTos;

public class MowerRepository implements IMowerRepository{

    private final DBService dbService;

    public MowerRepository(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void savaMowerState(Mower mover) {
        MowerTos mowerTos = new MowerTos();
        mowerTos.setUuid(mover.getUuid());
        MowerPlateau mowerPlateau = new MowerPlateau(mover.getPlanteau().getDimensionX(), mover.getPlanteau().getDimensionY());
        MowerOrientation mowerOrientation= MowerOrientation.getByString(mover.getCurrentPosition().getOrientation().toString());
        MowerPosition position = new MowerPosition(mover.getCurrentPosition().getPosInX(),mover.getCurrentPosition().getPosInY(), mowerOrientation, mowerPlateau);

    }
}
