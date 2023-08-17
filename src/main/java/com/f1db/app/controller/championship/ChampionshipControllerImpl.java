package com.f1db.app.controller.championship;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.app.model.mixedTable.DriverStandingTable;
import com.f1db.app.model.mixedTable.TeamChampTable;

import java.util.*;
import java.util.stream.Collectors;

public class ChampionshipControllerImpl extends ControllerImpl implements ChampionshipController {
    @Override
    public List<TeamChampTable> getTeamTable() {
        List<TeamChampTable> outlist = new ArrayList<>();
        /*Double points;
        String name;
        int position;
        int tempTeamId;
        Map<String, Double> unsortedMap = new HashMap<>();
        this.getQueryManager().getAllContract().forEach(c -> {
            this.getQueryManager().getAllDriver().forEach(d -> {
                if()
            });
        });*/
        return outlist;
    }

    @Override
    public List<DriverStandingTable> getDriverTable() {
        Map<String, Double> unsortedMap = new HashMap<>();
        for (var d : this.getQueryManager().getAllDriver()){
            double point = 0;
            for(var s : this.getQueryManager().getStandingByDriver(d.getDriverId())){
                point = point + s.getPoints();
            }
            unsortedMap.put(d.getSurname() + " " + d.getName(), point);
        }
        Map<String, Double> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        List<DriverStandingTable> outlist = new ArrayList<>();
        int position = 1;
        for (var l : sortedMap.entrySet()){
            outlist.add(new DriverStandingTable(l.getValue(), position, l.getKey()));
            position++;
        }
        return outlist;
    }
}
