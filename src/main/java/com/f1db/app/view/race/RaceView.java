package com.f1db.app.view.race;

import com.f1db.app.controller.race.RaceController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class RaceView extends AbstractFXView {

    @FXML
    private TableColumn<?, ?> championshipColumn;

    @FXML
    private MenuButton championshipMenu;

    @FXML
    private TableColumn<?, ?> driverColumn;

    @FXML
    private MenuButton inputChampionship;

    @FXML
    private TextField inputLaps;

    @FXML
    private TextField inputRound;

    @FXML
    private MenuButton inputTrack;

    @FXML
    private TableColumn<?, ?> lapsColumn;

    @FXML
    private TableColumn<?, ?> lengthColumn;

    @FXML
    private TableColumn<?, ?> locationColumn;

    @FXML
    private TableColumn<?, ?> pointsColumn;

    @FXML
    private TableColumn<?, ?> positionColumn;

    @FXML
    private MenuButton raceMenu;

    @FXML
    private TableView<?> raceTable;

    @FXML
    private TableColumn<?, ?> roundColumn;

    @FXML
    private TableView<?> standingTable;

    @FXML
    private TableColumn<?, ?> trackColumn;

    @Override
    public void init() {
        initRaceTable();
        initStandingTable();
    }

    private void initRaceTable() {
        trackColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(6));
        locationColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(6));
        lapsColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(6));
        lengthColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(6));
        roundColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(6));
        championshipColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(6));
    }

    private void initStandingTable() {
        positionColumn.prefWidthProperty().bind(standingTable.widthProperty().divide(3));
        pointsColumn.prefWidthProperty().bind(standingTable.widthProperty().divide(3));
        driverColumn.prefWidthProperty().bind(standingTable.widthProperty().divide(3));
    }

    @FXML
    void onAddTrackClick() {

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
    void onFindClick() {

    }

    @FXML
    void onNextClick() {

    }

    @FXML
    void onTeamClick() {

    }

    private RaceController getRaceController() {
        return (RaceController) this.getController();
    }
}
