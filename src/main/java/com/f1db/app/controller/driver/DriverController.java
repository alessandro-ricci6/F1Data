package com.f1db.app.controller.driver;

import com.f1db.app.controller.Controller;
import com.f1db.app.model.mixedTable.ContractTable;
import com.f1db.entity.Contract;
import com.f1db.entity.Driver;
import javafx.util.Pair;

import java.util.List;

public interface DriverController extends Controller {
    List<Driver> getAllDriver();
    List<Contract> getAllContract();
    void addDriver(String name, String surname, String nationality, int number, int engineer);
    void addContract(String driver, String team, int expYear, int signYear);
    List<Pair<Integer, Integer>> getDriverStanding(String driver);
    List<ContractTable> getContractTableList();
    void removeContract(ContractTable contractTable);
}
