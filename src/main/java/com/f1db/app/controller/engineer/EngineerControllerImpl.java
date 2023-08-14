package com.f1db.app.controller.engineer;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Engineer;

import java.util.List;

public class EngineerControllerImpl extends ControllerImpl implements EngineerController {
    @Override
    public void addEngineer(String name, String surname, String nationality) {
        Engineer engineer = new Engineer();
        engineer.setName(name);
        engineer.setNationality(nationality);
        engineer.setSurname(surname);
        this.getQueryManager().addEngineer(engineer);
    }

    @Override
    public List<Engineer> getAllEngineer() {
        return this.getQueryManager().getAllEngineer();
    }
}
