package com.f1db.app.view;

import com.f1db.app.controller.Controller;

public interface View {

    Controller getController();

    void setController(Controller controller);
}