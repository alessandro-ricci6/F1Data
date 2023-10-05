package com.f1db.app.model.mixedTable;

import com.f1db.entity.Driver;
import com.f1db.entity.Standing;

public class StandingTable {
    private double points;
    private int position;
    private String name;

    public StandingTable(Standing standing, Driver name){
        this.points = standing.getPoints();
        this.position = standing.getPosition();
        this.name = name.getSurname() + " " + name.getName();
    }

    public StandingTable(Double points, int position, String name) {
        this.points = points;
        this.position = position;
        this.name = name;
    }

    public double getPoints() {
        return this.points;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
