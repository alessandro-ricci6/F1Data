package com.f1db.app.model.mixedTable;

import com.f1db.entity.Contract;
import com.f1db.entity.Driver;
import com.f1db.entity.Team;

public class ContractTable {
    private int year;
    private String driver;
    private String team;

    public ContractTable(Driver driver, Team team, Contract contract) {
        this.driver = driver.getSurname() + " " + driver.getName();
        this.team = team.getName();
        this.year = contract.getExpiration();
    }

    public int getYear() {
        return this.year;
    }

    public String getDriver() {
        return this.driver;
    }

    public String getTeam() {
        return this.team;
    }
}
