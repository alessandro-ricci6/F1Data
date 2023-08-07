package com.f1db.app.controller.engineer;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Engineer;

public interface EngineerController extends Controller {

    boolean addEngineer(Engineer engineer);
}
