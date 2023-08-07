package com.f1db.app.view.team;

import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Car;
import com.f1db.entity.Team;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeamView extends AbstractFXView {

    @FXML
    private TableColumn<Car, String> carNameColumn;

    @FXML
    private TableColumn<Team, String> headquarterColumn;

    @FXML
    private TableColumn<Team, String> nameColumn;

    @FXML
    private TableColumn<Team, String> nationalityColumn;

    @FXML
    private TableColumn<Car, String> puSuppColumn;

    @FXML
    private TableView<Object> table;

    @Override
    public void init() {

    }

    @FXML
    void onDriverClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.DRIVER);
    }

    @FXML
    void onEngineerClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.ENGINEER);
    }

    @FXML
    void onRaceClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.RACE);
    }
}
