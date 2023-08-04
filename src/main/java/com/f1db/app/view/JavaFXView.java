package com.f1db.app.view;

import javafx.stage.Stage;

public interface JavaFXView extends View{

    Stage getStage();

    void setStage(Stage stage);

    void init();
}