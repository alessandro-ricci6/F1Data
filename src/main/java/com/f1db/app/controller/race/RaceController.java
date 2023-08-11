package com.f1db.app.controller.race;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Race;
import com.f1db.entity.Track;

import java.util.List;

public interface RaceController extends Controller {
    void addChampionship(int year);
    void addRace(Race race);
    List<Race> getRaceByYear(int year);
    Track getTrackByRace(Race race);
}
