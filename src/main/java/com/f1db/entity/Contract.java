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
    @Column(name = "team")
    private int team;
    public int getTeam() {
        return team;
    }
    public void setTeam(int team) {
        this.team = team;
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
    @Column(name = "deadline")
    private int deadline;
    public int getDeadline() {
        return deadline;
    }
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if(contractId != contract.contractId) return false;
        if(team != contract.team) return false;
        if(driver != contract.driver) return false;
        if(deadline != contract.deadline) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractId;
        result = result * 31 + team;
        result = result * 31 + driver;
        result = result * 31 + deadline;

        return result;
    }
}
