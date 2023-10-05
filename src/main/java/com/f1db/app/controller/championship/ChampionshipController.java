package com.f1db.app.controller.championship;

import com.f1db.app.controller.Controller;
import com.f1db.app.model.mixedTable.StandingTable;
import com.f1db.app.model.mixedTable.TeamChampTable;

import java.util.List;

public interface ChampionshipController extends Controller {
    List<StandingTable> getTeamTable(int year);
    List<StandingTable> getDriverTable(int year);
    List<Integer> getYear();
}
