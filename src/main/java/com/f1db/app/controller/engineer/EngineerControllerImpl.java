package com.f1db.app.controller.engineer;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.app.model.mixedTable.EngDriverTable;
import com.f1db.entity.Engineer;

import java.util.ArrayList;
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
    public List<EngDriverTable> getEngDriverTableList() {
        List<EngDriverTable> outList = new ArrayList<>();
        for(var e : this.getQueryManager().getAllEngineer()) {
            for(var d : this.getQueryManager().getAllDriver()) {
                if(d.getEngineer() == e.getEngineerId()) {
                    outList.add(new EngDriverTable(e, d));
                }
            }
        }
        return outList;
    }
}
