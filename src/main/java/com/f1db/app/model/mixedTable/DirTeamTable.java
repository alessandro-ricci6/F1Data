package com.f1db.app.model.mixedTable;

import com.f1db.entity.Director;
import com.f1db.entity.Team;

public class DirTeamTable {
    private String dirName;
    private String dirSurname;
    private String dirNationality;
    private String role;
    private String teamName;

    public DirTeamTable(Director director, Team team) {
        this.dirName = director.getName();
        this.dirSurname = director.getSurname();
        this.dirNationality = director.getNationality();
        this.role = director.getRole();
        this.teamName= team.getName();
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getDirSurname() {
        return this.dirSurname;
    }

    public String getDirNationality() {
        return this.dirNationality;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getRole() {
        return this.role;
    }
}
