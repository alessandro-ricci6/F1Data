package com.f1db.app.controller.team;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Team;

import java.util.List;

public class TeamControllerImpl extends ControllerImpl implements TeamController {
    @Override
    public List<Team> getAllTeam() {
        return this.getQueryManager().getAllTeam();
    }
}
