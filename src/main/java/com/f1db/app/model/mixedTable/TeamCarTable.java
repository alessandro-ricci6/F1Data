package com.f1db.app.model.mixedTable;

import com.f1db.entity.Car;
import com.f1db.entity.Team;

public class TeamCarTable {
    private String name;
    private String headquarter;
    private String nationality;
    private String carName;
    private String powerUnit;

    public TeamCarTable(Team team, Car car) {
        this.name = team.getName();
        this.headquarter = team.getHeadquarter();
        this.nationality = team.getNationality();
        this.carName = car.getCarName();
        this.powerUnit = car.getPowerUnit();
    }

    public String getName() {
        return this.name;
    }

    public String getHeadquarter() {
        return this.headquarter;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getPowerUnit() {
        return this.powerUnit;
    }
}
