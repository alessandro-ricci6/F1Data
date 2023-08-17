package com.f1db.app.view.championship;

import com.f1db.app.controller.championship.ChampionshipController;
import com.f1db.app.model.mixedTable.DriverStandingTable;
import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.app.model.mixedTable.TeamChampTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Driver;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChampionshipView extends AbstractFXView {
    @FXML
    private TableColumn<DriverStandingTable, String> driverNameColumn;

    @FXML
    private TableColumn<DriverStandingTable, Double> driverPointsColumn;

    @FXML
    private TableColumn<DriverStandingTable, Integer> driverPositionColumn;

    @FXML
    private TableView<DriverStandingTable> driverTable;

    @FXML
    private TableColumn<TeamChampTable, String> teamNameColumn;

    @FXML
    private TableColumn<TeamChampTable, Double> teamPointsColumn;

    @FXML
    private TableColumn<TeamChampTable, Integer> teamPositionColumn;

    @FXML
    private TableView<TeamChampTable> teamTable;
    @Override
    public void init() {
        initDriverStandingTable();
    }

    void initTeamtable() {
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        teamPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        teamPositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        teamNameColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        teamPointsColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        teamPositionColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        //teamTable.setItems(FXCollections.observableList());
    }

    void initDriverStandingTable() {
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));
        driverPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        driverPositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        driverNameColumn.prefWidthProperty().bind(driverTable.widthProperty().divide(3));
        driverPointsColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        driverPositionColumn.prefWidthProperty().bind(teamTable.widthProperty().divide(3));
        driverTable.setItems(FXCollections.observableList(this.getChampionshipController().getDriverTable()));
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
