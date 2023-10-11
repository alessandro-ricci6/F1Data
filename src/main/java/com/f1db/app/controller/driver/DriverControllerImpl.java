package com.f1db.app.controller.driver;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.app.model.mixedTable.ContractTable;
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
    public void addContract(String driver, String team, int expYear, int signYear) {
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
        contract.setSigning(signYear);
        contract.setExpiration(expYear);
        if(checkIfContractExist(driverId, teamId)) {
            this.getQueryManager().updateContract(contract);
        } else {
            this.getQueryManager().addContract(contract);
        }
    }

    @Override
    public List<Pair<Integer, Integer>> getDriverStanding(String driver, int year) {
        List<Pair<Integer, Integer>> outList = new ArrayList<>();
        for (var d : this.getQueryManager().getAllDriver()) {
            if((d.getSurname() + ", " + d.getName()).equals(driver)) {
                for (var r: this.getQueryManager().getRaceByYear(year)) {
                    for (var s: this.getQueryManager().getStandingByRace(r.getRaceId())){
                        if (s.getDriver() == d.getDriverId()){
                            outList.add(new Pair<>(getRound(s.getRace()), s.getPosition()));
                        }
                    }
                }
            }
        }
        return outList;
    }

    @Override
    public List<ContractTable> getContractTableList() {
        List<ContractTable> outList = new ArrayList<>();
        this.getQueryManager().getAllContract().forEach(c ->
                this.getQueryManager().getAllDriver().forEach(d ->
                        this.getQueryManager().getAllTeam().stream()
                                .filter(t -> c.getDriver() == d.getDriverId() && c.getTeam() == t.getTeamId())
                                .map(t -> new ContractTable(d, t, c))
                                .forEach(outList::add)
                )
        );
        return outList;
    }

    @Override
    public void removeContract(ContractTable contractTable) {
        Contract contract = new Contract();
        this.getQueryManager().getAllTeam().forEach(t -> {
            if(t.getName().equals(contractTable.getTeam())) contract.setTeam(t.getTeamId());
        });
        this.getQueryManager().getAllDriver().forEach(d -> {
            if((d.getSurname() + " " + d.getName()).equals(contractTable.getDriver()))
                contract.setDriver(d.getDriverId());
        });
        this.getQueryManager().deleteContract(contract);
    }

    @Override
    public int getRaceNumber(int year) {
        return this.getQueryManager().getRaceByYear(year).size();
    }

    private int getRound(int id) {
        for (var r : this.getQueryManager().getAllRaces()) {
            if(r.getRaceId() == id){
                return r.getRound();
            }
        }
        return 0;
    }

    private boolean checkIfContractExist(int driverId, int teamId){
        List<Contract> contractList = this.getQueryManager().getAllContract();
        for (var c : contractList) {
            if(c.getTeam() == teamId && c.getDriver() == driverId){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Integer> getYear() {
        List<Integer> yearList = new ArrayList<>();
        this.getQueryManager().getAllChampionship().forEach(c -> yearList.add(c.getYear()));
        return yearList;
    }
}
