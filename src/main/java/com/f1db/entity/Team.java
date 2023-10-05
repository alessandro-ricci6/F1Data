package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Team {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "teamId")
    private int teamId;
    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
    @Column(name = "nationality")
    private String nationality;
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "headquarter")
    private String headquarter;
    public String getHeadquarter() {
        return headquarter;
    }
    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if(teamId != team.teamId) return false;
        if(name != null ? name.equals(team.name) : team.name != null) return false;
        if(nationality != null ? nationality.equals(team.nationality) : team.nationality != null) return false;
        if(headquarter != null ? headquarter.equals(team.headquarter) : team.headquarter != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId;
        result = result * 31 + (name != null ? name.hashCode() : 0);
        result = result * 31 + (nationality != null ? nationality.hashCode() : 0);
        result = result * 31 + (headquarter != null ? headquarter.hashCode() : 0);

        return result;
    }
}
