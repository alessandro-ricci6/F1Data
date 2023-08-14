package com.f1db.app.controller.team;

import com.f1db.app.controller.Controller;
import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.entity.Car;
import com.f1db.entity.Team;

import java.util.List;

public interface TeamController extends Controller {
    void addTeam(String name, String headquarter, String nationality);
    void addCar(String name, String powerUnit, String teamName);
    List<String> getDriver();
    List<TeamCarTable> getTeamTable();
}
