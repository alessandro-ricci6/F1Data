package com.f1db.app.view;

import javafx.stage.Stage;

public abstract class AbstractFXView extends SimpleView implements JavaFXView{

    private Stage stage;

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}

