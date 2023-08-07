package com.f1db.app.controller.race;

import com.f1db.app.controller.ControllerImpl;

public class RaceControllerImpl extends ControllerImpl implements RaceController {
    @Override
    public void addChampionship(int year) {
        this.getQueryManager().addChampionship(year);
    }
}
