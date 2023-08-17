package com.f1db.app.controller.championship;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.app.model.mixedTable.StandingTable;
import com.f1db.app.model.mixedTable.TeamChampTable;
import com.f1db.entity.Race;

import java.util.*;
import java.util.stream.Collectors;

public class ChampionshipControllerImpl extends ControllerImpl implements ChampionshipController {
    @Override
    public List<StandingTable> getTeamTable(int year) {
        List<StandingTable> driverList = getDriverTable(year);
        Map<String, Double> unsortedMap = new HashMap<>();
        this.getQueryManager().getAllTeam().forEach(t -> {
            double points = 0.0;
            for(var c : this.getQueryManager().getAllContract()){
                for(var d : this.getQueryManager().getAllDriver()){
                    if(c.getTeam() == t.getTeamId() && c.getDriver() == d.getDriverId()){
                        for(var dl : driverList){
                            if (dl.getName().equals(d.getSurname() + " " +d.getName()))
                                points = points + dl.getPoints();
                        }
                    }
                }
            }
            unsortedMap.put(t.getName(), points);
        });
        return getList(unsortedMap);
    }

    @Override
    public List<StandingTable> getDriverTable(int year) {
        Map<String, Double> unsortedMap = new HashMap<>();
        for (var d : this.getQueryManager().getAllDriver()){
            double point = 0;
            for(var s : this.getQueryManager().getStandingByDriver(d.getDriverId())){
                if(checkRace(year, s.getRace())) point = point + s.getPoints();
            }
            unsortedMap.put(d.getSurname() + " " + d.getName(), point);
        }
        return getList(unsortedMap);
    }

    @Override
    public List<Integer> getYear() {
        List<Integer> outlist = new ArrayList<>();
        this.getQueryManager().getAllChampionship().forEach(c -> outlist.add(c.getYear()));
        return outlist;
    }

    private boolean checkRace(int year, int raceId) {
        for (var c : this.getQueryManager().getAllChampionship()){
            for (var r : this.getQueryManager().getAllRaces()){
                Race race = new Race();
                if(r.getRaceId() == raceId) race = r;
                if(race.getChampionship() == c.getChampionshipId() && year == c.getYear())
                    return true;
            }
        }
        return false;
    }

    private List<StandingTable> getList(Map<String, Double> unsortedMap){
        Map<String, Double> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        List<StandingTable> outlist = new ArrayList<>();
        int position = 1;
        for (var l : sortedMap.entrySet()){
            outlist.add(new StandingTable(l.getValue(), position, l.getKey()));
            position++;
        }
        return outlist;
    }
}
