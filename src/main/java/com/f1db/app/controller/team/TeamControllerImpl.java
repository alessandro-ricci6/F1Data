package com.f1db.app.controller.team;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.app.model.mixedTable.DirTeamTable;
import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.entity.Car;
import com.f1db.entity.Director;
import com.f1db.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamControllerImpl extends ControllerImpl implements TeamController {

    @Override
    public void addTeam(String name, String headquarter, String nationality) {
        Team team = new Team();
        team.setHeadquarter(headquarter);
        team.setName(name);
        team.setNationality(nationality);
        this.getQueryManager().addTeam(team);
    }

    @Override
    public void addCar(String name, String powerUnit, String teamName) {
        Car car = new Car();
        car.setCarName(name);
        car.setPowerUnit(powerUnit);
        for (var t : this.getQueryManager().getAllTeam()){
            if(teamName.equals(t.getName())){
                car.setTeam(t.getTeamId());
            }
        }
        this.getQueryManager().addCar(car);
    }

    @Override
    public List<String> getDriver() {
        List<String> outList = new ArrayList<>();
        this.getQueryManager().getAllDriver().forEach(d -> outList.add(d.getSurname() + ", " + d.getName()));
        return outList;
    }

    @Override
    public List<TeamCarTable> getTeamTable() {
        List<TeamCarTable> outList = new ArrayList<>();
        for(var t : this.getQueryManager().getAllTeam()) {
            for (var c : this.getQueryManager().getAllCar()){
                if(t.getTeamId() == c.getTeam()){
                    outList.add(new TeamCarTable(t, c));
                }
            }
        }
        return outList;
    }

    @Override
    public void addDir(String name, String surname, String nationality, String role, String team) {
        Director director = new Director();
        director.setRole(role);
        director.setName(name);
        director.setSurname(surname);
        director.setNationality(nationality);
        for (var t : this.getQueryManager().getAllTeam()){
            if(t.getName().equals(team)) director.setTeam(t.getTeamId());
        }
        this.getQueryManager().addDirector(director);
    }

    @Override
    public List<DirTeamTable> getDirTable() {
        List<DirTeamTable> outlist = new ArrayList<>();
        this.getQueryManager().getAlldirectors().forEach(d -> {
            this.getQueryManager().getAllTeam().forEach(t -> {
                if(d.getTeam() == t.getTeamId()) outlist.add(new DirTeamTable(d, t));
            });
        });

        return outlist;
    }

    @Override
    public List<String> getTeamList() {
        return this.getQueryManager().getAllTeam().stream().map(Team::getName).toList();
    }
}
