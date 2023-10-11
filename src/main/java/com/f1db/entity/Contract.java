package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Contract {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contractId")
    private int contractId;
    public int getContractId() {
        return contractId;
    }
    public void setContractId(int contractId) {
        this.contractId = contractId;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "driver_driverId")
    private int driver;
    public int getDriver() {
        return driver;
    }
    public void setDriver(int driver) {
        this.driver = driver;
    }

    @Basic
    @Column(name = "signing")
    private int signing;
    public int getSigning() { return signing; }
    public void setSigning(int signing) { this.signing = signing; }

    @Basic
    @Column(name = "expiration")
    private int expiration;
    public int getExpiration() {
        return expiration;
    }
    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if(contractId != contract.contractId) return false;
        if(team != contract.team) return false;
        if(driver != contract.driver) return false;
        if(expiration != contract.expiration) return false;
        if(signing != contract.signing) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractId;
        result = result * 31 + team;
        result = result * 31 + driver;
        result = result * 31 + expiration;

        return result;
    }
}
