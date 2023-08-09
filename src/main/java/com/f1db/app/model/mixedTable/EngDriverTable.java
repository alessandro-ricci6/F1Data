package com.f1db.app.model.mixedTable;

import com.f1db.entity.Engineer;
import com.f1db.entity.Driver;

public class EngDriverTable {

    private String name;
    private String surname;
    private String nationality;
    private String driver;

    public EngDriverTable(Engineer engineer, Driver driver) {
        this.name = engineer.getName();
        this.surname = engineer.getSurname();
        this.nationality = engineer.getNationality();
        this.driver = driver.getSurname() + " " + driver.getName();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getDriver() {
        return this.driver;
    }
}
