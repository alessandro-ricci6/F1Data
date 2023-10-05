package com.f1db.app.controller.race;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.app.model.mixedTable.RaceTable;
import com.f1db.entity.Championship;
import com.f1db.entity.Race;
import com.f1db.entity.Track;

import java.util.ArrayList;
import java.util.List;

public class RaceControllerImpl extends ControllerImpl implements RaceController {
    @Override
    public void addChampionship(int year) {
        this.getQueryManager().addChampionship(year);
    }

    @Override
    public void addRace(int championship, String laps, String round, String track, boolean sprintRace) {
        Race race = new Race();
        for (var c :this.getQueryManager().getAllChampionship()){
            if(c.getYear() == championship){
                race.setChampionship(c.getChampionshipId());
            }
        }
        race.setLaps(Integer.parseInt(laps));
        race.setRound(Integer.parseInt(round));
        race.setSprintRace(sprintRace);
        for(var t : this.getQueryManager().getAllTrack()){
            if(t.getName().equals(track)){
                race.setTrack(t.getTrackId());
            }
        }
        this.getQueryManager().addRace(race);
    }

    @Override
    public List<Race> getRaceByYear(int year) {
        return this.getQueryManager().getRaceByYear(year);
    }

    @Override
    public Track getTrackByRace(Race race) {
        for (var t : this.getQueryManager().getAllTrack()) {
            if(race.getTrack() == t.getTrackId()){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<RaceTable> getRaceTableList() {
        List<RaceTable> outList = new ArrayList<>();
        this.getQueryManager().getAllRaces().forEach(r -> {
            this.getQueryManager().getAllTrack().forEach(t -> {
                this.getQueryManager().getAllChampionship().forEach(c -> {
                    if(r.getTrack() == t.getTrackId() && r.getChampionship() == c.getChampionshipId()){
                        outList.add(new RaceTable(t, r, c));
                    }
                });
            });
        });
        return outList;
    }

    public String getRaceType(boolean raceType){
        if(raceType) return "Sprint";
        else return "Long";
    }
}
