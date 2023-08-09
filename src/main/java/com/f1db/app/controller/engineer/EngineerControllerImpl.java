package com.f1db.app.controller.engineer;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Engineer;

import java.util.List;

public class EngineerControllerImpl extends ControllerImpl implements EngineerController {
    @Override
    public boolean addEngineer(Engineer engineer) {
        if(engineer.getName() == null || engineer.getSurname() == null) {
            return false;
        }
        this.getQueryManager().addEngineer(engineer);
        return true;
    }

    @Override
    public List<Engineer> getAllEngineer() {
        return this.getQueryManager().getAllEngineer();
    }
}
