package com.f1db.app.controller;

import com.f1db.app.model.QueryManager;
import com.f1db.app.view.View;

public interface Controller {
    void setView(View view);

    View getView();

    QueryManager getQueryManager();
}
