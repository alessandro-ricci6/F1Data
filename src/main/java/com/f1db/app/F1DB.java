package com.f1db.app;

import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class F1DB extends Application {
    public void start(Stage stage) throws Exception {
        stage.setTitle("F1DB");

        SceneManager.getInstance().switchPage(stage, Pages.DRIVER);
    }
}
