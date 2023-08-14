package com.f1db.app.controller.team;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Car;
import com.f1db.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamControllerImpl extends ControllerImpl implements TeamController {
    @Override
    public List<Team> getAllTeam() {
        return this.getQueryManager().getAllTeam();
    }

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
    public List<Car> getAllCar() {
        return this.getQueryManager().getAllCar();
    }

    @Override
    public List<String> getDriver() {
        List<String> outList = new ArrayList<>();
        this.getQueryManager().getAllDriver().forEach(d -> outList.add(d.getSurname() + ", " + d.getName()));
        return outList;
    }
}
