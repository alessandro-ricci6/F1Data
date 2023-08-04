package com.f1db.app.controller.driver;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Driver;

import java.util.List;

public interface DriverController extends Controller {
    List<Driver> getAllDriver();
}
