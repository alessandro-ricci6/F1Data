package com.f1db.app.controller.engineer;

import com.f1db.app.controller.Controller;
import com.f1db.app.model.mixedTable.EngDriverTable;
import com.f1db.entity.Engineer;

import java.util.List;

public interface EngineerController extends Controller {

    void     addEngineer(String name, String surname, String nationality);
    List<EngDriverTable> getEngDriverTableList();
}
