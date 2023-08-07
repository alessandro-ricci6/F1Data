package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Driver {
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(name = "driverId")
    private int driverId;
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    private String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "number")
    private int number;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "Nationality")
    private String nationality;
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(name = "engineer_engineerId")
    private int engineer;
    public int getEngineer() {
        return engineer;
    }
    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if(driverId != driver.driverId) return false;
        if(name != null ? name.equals(driver.name) : driver.name != null) return false;
        if(surname != null ? surname.equals(driver.surname) : driver.surname != null) return false;
        if(number != driver.number) return false;
        if(nationality != null ? nationality.equals(driver.nationality) : driver.nationality != null) return false;
        if(engineer != driver.engineer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = result * 31 + (name != null ? name.hashCode() : 0);
        result = result * 31 + (surname != null ? surname.hashCode() : 0);
        result = result * 31 + number;
        result = result * 31 + (nationality != null ? nationality.hashCode() : 0);
        result = result * 31 + engineer;

        return result;
    }
}
