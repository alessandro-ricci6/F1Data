package com.f1db.entity;

import jakarta.persistence.*;

import java.security.PublicKey;

@Entity
public class Championship {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "championshipId")
    private int championshipId;
    public int getChampionshipId() {
        return championshipId;
    }
    public void setChampionshipId(int championshipId) {
        this.championshipId = championshipId;
    }

    @Id
    @Column(name = "year")
    private int year;
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Championship championship = (Championship) o;

        if(championshipId != championship.championshipId) return false;
        if(year != championship.year) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = championshipId;
        result = result * 31 + year;

        return result;
    }
}
