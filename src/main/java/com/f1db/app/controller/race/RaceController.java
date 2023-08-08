package com.f1db.app.controller.race;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Race;

public interface RaceController extends Controller {
    void addChampionship(int year);
    void addRace(Race race);
}
