package com.f1db.app.view.race;

import com.f1db.app.controller.race.RaceController;
import com.f1db.app.view.AbstractFXView;
import javafx.fxml.FXML;
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

    }

    @FXML
    void onAddTrackClick() {

    }

    @FXML
    void onDriverClick() {

    }

    @FXML
    void onEngineerClick() {

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
