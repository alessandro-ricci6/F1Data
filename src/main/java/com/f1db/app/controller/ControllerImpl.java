package com.f1db.app.controller;

import com.f1db.app.view.View;

public class ControllerImpl implements Controller{
    private View view;
    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    }
}
