package com.f1db.app.controller.team;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Team;

import java.util.List;

public interface TeamController extends Controller {
    List<Team> getAllTeam();
}
