package com.f1db.app.controller.race;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Race;

public class RaceControllerImpl extends ControllerImpl implements RaceController {
    @Override
    public void addChampionship(int year) {
        this.getQueryManager().addChampionship(year);
    }

    @Override
    public void addRace(Race race) {
        this.getQueryManager().addRace(race);
    }
}
