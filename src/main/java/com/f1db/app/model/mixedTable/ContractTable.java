package com.f1db.app.model.mixedTable;

import com.f1db.entity.Contract;
import com.f1db.entity.Driver;
import com.f1db.entity.Team;

public class ContractTable {
    private int expYear;
    private int signYear;
    private String driver;
    private String team;

    public ContractTable(Driver driver, Team team, Contract contract) {
        this.driver = driver.getSurname() + " " + driver.getName();
        this.team = team.getName();
        this.expYear = contract.getExpiration();
        this.signYear = contract.getSigning();
    }

    public int getExpYear() {
        return this.expYear;
    }

    public int getSignYear() { return this.signYear; }

    public String getDriver() {
        return this.driver;
    }

    public String getTeam() {
        return this.team;
    }
}
