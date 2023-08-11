package com.f1db.app.controller.standing;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Driver;

public interface StandingController extends Controller {
    void addStanding(Driver driver, int position);
}
