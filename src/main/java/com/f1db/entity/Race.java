package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Race {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "raceId")
    private int raceId;
    public int getRaceId() {
        return raceId;
    }
    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    @Basic
    @Column(name = "laps")
    private int laps;
    public int getLaps() {
        return laps;
    }
    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Basic
    @Column(name = "round")
    private int round;
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }

    @Basic
    @Column(name = "sprintRace")
    private boolean sprintRace;

    public boolean isSprintRace() {
        return this.sprintRace;
    }

    public void setSprintRace(boolean sprintRace) {
        this.sprintRace = sprintRace;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "track_trackId")
    private int track;
    public int getTrack() {
        return track;
    }
    public void setTrack(int track) {
        this.track = track;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "championship_championshipId")
    private int championship;
    public int getChampionship() {
        return championship;
    }
    public void setChampionship(int championship) {
        this.championship = championship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Race race = (Race) o;

        if(raceId != race.raceId) return false;
        if(laps != race.laps) return false;
        if(round != race.round) return false;
        if(track != race.track) return false;
        if(championship != race.championship) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = raceId;
        result = result * 31 + laps;
        result = result * 31 + round;
        result = result * 31 + track;
        result = result * 31 + championship;

        return result;
    }
}
