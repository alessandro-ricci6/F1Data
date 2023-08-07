package com.f1db.app.view.race;

import com.f1db.app.controller.race.RaceController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Championship;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RaceView extends AbstractFXView {

    @FXML
    private TableColumn<?, ?> championshipColumn;

    @FXML
    private MenuButton championshipMenu;

    @FXML
    private TableColumn<?, ?> driverColumn;

    @FXML
    private ChoiceBox<Integer> inputChampionship;

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
        initChampMenu();
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

    private void initChampMenu() {
        List<Integer> yearList = new ArrayList<>();
        List<Championship> champList = this.getRaceController().getQueryManager().getAllChampionship();
        champList.forEach(c -> yearList.add(c.getYear()));
        inputChampionship.setItems(FXCollections.observableList(yearList));
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
        SceneManager.getInstance().switchPage(new Stage(), Pages.STANDING);
    }

    @FXML
    void onTeamClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.TEAM);
    }

    @FXML
    void onAddChampionshipClick() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add championship");
        //dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Enter the year of the championship");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(s -> this.getRaceController().addChampionship(Integer.parseInt(s)));

    }

    private RaceController getRaceController() {
        return (RaceController) this.getController();
    }
}
