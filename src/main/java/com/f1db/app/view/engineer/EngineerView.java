package com.f1db.app.view.engineer;

import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Driver;
import com.f1db.entity.Engineer;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EngineerView extends AbstractFXView {

    @FXML
    private TableView<Object> table;

    @FXML
    private TableColumn<Driver, String> columnDriver;

    @FXML
    private TableColumn<Engineer, String> columnName;

    @FXML
    private TableColumn<Engineer, String> columnNationality;

    @FXML
    private TableColumn<Engineer, String> columnSurname;

    @FXML
    private TextField findInput;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNationality;

    @FXML
    private TextField inputSurname;

    @FXML
    void onAddClick() {

    }

    @FXML
    void onDriverClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.DRIVER);
    }

    @FXML
    void onRaceClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.RACE);
    }

    @FXML
    void onTeamClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.TEAM);
    }

    @Override
    public void init() {

    }
}
