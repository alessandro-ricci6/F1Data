package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "carId")
    private int carId;
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public int getCarId() {
        return this.carId;
    }

    @Id
    @Column(name = "name")
    private String carName;
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Basic
    @Column(name = "powerUnit")
    private String powerUnit;
    public String getPowerUnit() {
        return powerUnit;
    }
    public void setPowerUnit(String powerUnit) {
        this.powerUnit = powerUnit;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "team_teamId")
    private int team;
    public int getTeam() {
        return team;
    }
    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        if (carId != car.carId) return false;
        if (carName != null ? !carName.equals(car.carName) : car.carName != null) return false;
        if (powerUnit != null ? !powerUnit.equals(car.powerUnit) : car.powerUnit != null) return false;
        if (team != car.team) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = result * 31 + (carName != null ? carName.hashCode() : 0);
        result = result * 32 + (powerUnit != null ? powerUnit.hashCode() : 0);
        result = result * 31 + team;

        return result;
    }
}
