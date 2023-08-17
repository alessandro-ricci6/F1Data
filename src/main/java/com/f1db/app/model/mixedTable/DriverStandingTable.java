package com.f1db.app.model.mixedTable;

import com.f1db.entity.Driver;
import com.f1db.entity.Standing;

public class DriverStandingTable {
    private double points;
    private int position;
    private String driver;

    public DriverStandingTable(Standing standing, Driver driver){
        this.points = standing.getPoints();
        this.position = standing.getPosition();
        this.driver = driver.getSurname() + " " + driver.getName();
    }

    public DriverStandingTable(Double points, int position, String driver) {
        this.points = points;
        this.position = position;
        this.driver = driver;
    }

    public double getPoints() {
        return this.points;
    }

    public int getPosition() {
        return this.position;
    }

    public String getDriver() {
        return this.driver;
    }
}
