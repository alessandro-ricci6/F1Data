package com.f1db.app.controller.driver;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Contract;
import com.f1db.entity.Driver;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DriverControllerImpl extends ControllerImpl implements DriverController {
    @Override
    public List<Driver> getAllDriver() {
        return this.getQueryManager().getAllDriver();
    }

    @Override
    public List<Contract> getAllContract() {
        return this.getQueryManager().getAllContract();
    }

    @Override
    public void addDriver(String name, String surname, String nationality, int number, int engineer) {
        this.getQueryManager().addDriver(name, surname, nationality, number, engineer);
    }

    @Override
    public void addContract(String driver, String team, int year) {
        int driverId = 0;
        int teamId = 0;
        Contract contract = new Contract();
        for (var d : this.getQueryManager().getAllDriver()){
            if (driver.equals(d.getSurname())) {
                driverId = d.getDriverId();
            }
        }
        for (var t : this.getQueryManager().getAllTeam()){
            if (team.equals(t.getName())){
                teamId = t.getTeamId();
            }
        }
        contract.setDriver(driverId);
        contract.setTeam(teamId);
        contract.setExpiration(year);
        this.getQueryManager().addContract(contract);
    }

    @Override
    public List<Pair<Integer, Double>> getDriverStanding(String driver) {
        List<Pair<Integer, Double>> outList = new ArrayList<>();
        for (var d : this.getQueryManager().getAllDriver()) {
            if((d.getSurname() + ", " + d.getName()).equals(driver)) {
                this.getQueryManager().getStandingByDriver(d.getDriverId())
                        .forEach(s -> outList.add(new Pair<>(getRound(s.getRace()), s.getPoints())));
            }
        }
        return outList;
    }

    private int getRound(int id) {
        for (var r : this.getQueryManager().getAllRaces()) {
            if(r.getRaceId() == id){
                return r.getRound();
            }
        }
        return 0;
    }
}
