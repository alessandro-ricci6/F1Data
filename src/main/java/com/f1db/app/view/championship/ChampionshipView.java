package com.f1db.app.view.championship;

import com.f1db.app.controller.championship.ChampionshipController;
import com.f1db.app.model.mixedTable.StandingTable;
import com.f1db.app.model.mixedTable.TeamChampTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChampionshipView extends AbstractFXView {
    @FXML
    private TableColumn<StandingTable, String> driverNameColumn;

    @FXML
    private TableColumn<StandingTable, Double> driverPointsColumn;

    @FXML
    private TableColumn<StandingTable, Integer> driverPositionColumn;

    @FXML
    private TableView<StandingTable> driverTable;

    @FXML
    private ChoiceBox<Integer> driverYearInput;

    @FXML
    private TableColumn<StandingTable, String> teamNameColumn;

    @FXML
    private TableColumn<StandingTable, Double> teamPointsColumn;

    @FXML
    private TableColumn<StandingTable, Integer> teamPositionColumn;

    @FXML
    private TableView<StandingTable> teamTable;

    @FXML
    private ChoiceBox<Integer> teamYearInput;
    @Override
    public void init() {
        initChoiceBox();
        driverNameColumn.prefWidthProperty().bind(driverTable.widthProperty().divide(3));
        driverPointsColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        driverPositionColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        teamNameColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        teamPointsColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        teamPositionColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
    }

    void initTeamTable(int year) {
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        teamPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        teamPositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        teamTable.setItems(FXCollections.observableList(this.getChampionshipController().getTeamTable(year)));
    }

    void initDriverStandingTable(int year) {
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        driverPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        driverPositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        driverTable.setItems(FXCollections.observableList(this.getChampionshipController().getDriverTable(year)));
    }

    void initChoiceBox(){
        driverYearInput.setItems(FXCollections.observableList(this.getChampionshipController().getYear()));
        driverYearInput.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            initDriverStandingTable(newValue);
        });
        teamYearInput.setItems(FXCollections.observableList(this.getChampionshipController().getYear()));
        teamYearInput.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            initTeamTable(newValue);
        });
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

    @FXML
    void onTeamClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.TEAM);
    }

    private ChampionshipController getChampionshipController(){
        return (ChampionshipController) this.getController();
    }
}
