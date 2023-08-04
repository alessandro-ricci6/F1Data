package com.f1db.app.view;

import com.f1db.app.controller.Controller;

public class SimpleView implements View{
    private Controller controller;

    public Controller getController() {
        return this.controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}