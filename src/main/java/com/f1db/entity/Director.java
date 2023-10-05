package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Director {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "directorId")
    private int directorId;
    public int getDirectorId() {
        return directorId;
    }
    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Basic
    @Column(name = "role")
    private String role;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
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

        Director director = (Director) o;

        if(directorId != director.directorId) return false;
        if(role != null ? role.equals(director.role) : director.role != null) return false;
        if(name != null ? name.equals(director.name) : director.name != null) return false;
        if(surname != null ? surname.equals(director.surname) : director.surname != null) return false;
        if(nationality != null ? nationality.equals(director.nationality) : director.nationality != null) return false;
        if(team != director.team) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directorId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + team;

        return result;
    }

}
