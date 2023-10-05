package com.f1db.app.model.mixedTable;

public class TeamChampTable {
    private int position;
    private String team;
    private Double points;

    public TeamChampTable(int position, String team, Double points){
        this.points = points;
        this.position = position;
        this.team = team;
    }

    public int getPosition() {
        return this.position;
    }

    public String getTeam() {
        return this.team;
    }

    public Double getPoints() {
        return this.points;
    }
}
