package com.f1db.app.controller.driver;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Driver;

import java.util.List;

public class DriverControllerImpl extends ControllerImpl implements DriverController {
    @Override
    public List<Driver> getAllDriver() {
        return this.getQueryManager().getAllDriver();
    }

    @Override
    public boolean addDriver(String name, String surname, String nationality, int number, int engineer) {
        if(name == null || surname == null || nationality == null) {
            return false;
        }
        this.getQueryManager().addDriver(name, surname, nationality, number, engineer);
        return true;
    }
}
