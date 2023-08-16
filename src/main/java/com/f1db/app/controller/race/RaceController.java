package com.f1db.app.controller.race;

import com.f1db.app.controller.Controller;
import com.f1db.app.model.mixedTable.RaceTable;
import com.f1db.entity.Championship;
import com.f1db.entity.Race;
import com.f1db.entity.Track;

import java.util.List;

public interface RaceController extends Controller {
    void addChampionship(int year);
    void addRace(int championship, String laps, String round, String track, boolean sprintRace);
    List<Race> getRaceByYear(int year);
    Track getTrackByRace(Race race);
    List<RaceTable> getRaceTableList();
    String getRaceType(boolean raceType);
}
