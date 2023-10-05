package com.f1db.app.model.mixedTable;

import com.f1db.entity.Championship;
import com.f1db.entity.Race;
import com.f1db.entity.Track;

public class RaceTable {
    private String trackName;
    private String trackLocation;
    private int laps;
    private int length;
    private int round;
    private int championship;
    private String raceType;

    public RaceTable(Track track, Race race, Championship championship) {
        this.trackName = track.getName();
        this.trackLocation = track.getCity() + ", " + track.getCountry();
        this.laps = race.getLaps();
        this.length = track.getLength();
        this.round = race.getRound();
        this.championship = championship.getYear();
        if (race.isSprintRace()) raceType = "Sprint";
        else raceType = "Long";
    }

    public String getTrackName() {
        return this.trackName;
    }

    public String getTrackLocation() {
        return this.trackLocation;
    }

    public int getLaps() {
        return this.laps;
    }

    public int getLength() {
        return this.length;
    }

    public int getRound() {
        return this.round;
    }

    public int getChampionship() {
        return this.championship;
    }

    public String getRaceType() {return this.raceType;}
}
