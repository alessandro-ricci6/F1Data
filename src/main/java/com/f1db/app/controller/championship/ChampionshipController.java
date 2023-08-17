package com.f1db.app.controller.championship;

import com.f1db.app.controller.Controller;
import com.f1db.app.model.mixedTable.DriverStandingTable;
import com.f1db.app.model.mixedTable.TeamChampTable;

import java.util.List;

public interface ChampionshipController extends Controller {
    List<TeamChampTable> getTeamTable();
    List<DriverStandingTable> getDriverTable();
}
