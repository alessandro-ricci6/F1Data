package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Engineer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "engineerId")
    private int engineerId;
    public int getEngineerId() {
        return engineerId;
    }
    public void setEngineerId(int engineerId) {
        this.engineerId = engineerId;
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
    @Column(name = "nationality")
    private String nationality;
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engineer engineer = (Engineer) o;

        if(engineerId != engineer.engineerId) return false;
        if(name != null ? name.equals(engineer.name) : engineer.name != null) return false;
        if(surname != null ? surname.equals(engineer.surname) : engineer.surname != null) return false;
        if(nationality != null ? nationality.equals(engineer.nationality) : engineer.nationality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = engineerId;
        result = result * 31 + (name != null ? name.hashCode() : 0);
        result = result * 31 + (surname != null ? surname.hashCode() : 0);
        result = result * 31 + (nationality != null ? nationality.hashCode() : 0);

        return result;
    }
}
