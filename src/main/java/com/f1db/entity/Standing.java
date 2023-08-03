package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Standing {
    @Id
    @Column(name = "position")
    private int position;
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race")
    private int race;
    public int getRace() {
        return race;
    }
    public void setRace(int race) {
        this.race = race;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "driver")
    private int driver;
    public int getDriver() {
        return driver;
    }
    public void setDriver(int driver) {
        this.driver = driver;
    }

    @Basic
    @Column(name = "points")
    private Double points;
    public Double getPoints() {
        return points;
    }
    public void setPoints(Double points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Standing standing = (Standing) o;

        if(race != standing.race) return false;
        if(driver != standing.driver) return false;
        if(points != null ? points.equals(standing.points) : standing.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = race;
        result = result * 31 + driver;
        result = result * 31 + (points != null ? points.hashCode() : 0);

        return result;
    }
}
