package com.f1db.app.view.team;

import com.f1db.app.controller.team.TeamController;
import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.*;
import com.f1db.entity.Car;
import com.f1db.entity.Team;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TeamView extends AbstractFXView {

    @FXML
    private TextField inputHeadquarter;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNationality;

    @FXML
    private TableColumn<TeamCarTable, String> carNameColumn;

    @FXML
    private TableColumn<TeamCarTable, String> headquarterColumn;

    @FXML
    private TableColumn<TeamCarTable, String> nameColumn;

    @FXML
    private TableColumn<TeamCarTable, String> nationalityColumn;

    @FXML
    private TableColumn<TeamCarTable, String> puSuppColumn;

    @FXML
    private TableView<TeamCarTable> table;

    @FXML
    private TextField inputPU;

    @FXML
    private TextField inputCarName;

    @Override
    public void init() {
        initTeamTable();
    }

    private void initTeamTable() {
        carNameColumn.setCellValueFactory(new PropertyValueFactory<>("carName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        headquarterColumn.setCellValueFactory(new PropertyValueFactory<>("headquarter"));
        puSuppColumn.setCellValueFactory(new PropertyValueFactory<>("powerUnit"));
        carNameColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        nameColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        nationalityColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        headquarterColumn.prefWidthProperty().bind(table.widthProperty().divide(5));
        puSuppColumn.prefWidthProperty().bind(table.widthProperty().divide(5));

        List<TeamCarTable> list = new ArrayList<>();
        for(var t : this.getTeamController().getAllTeam()) {
            for (var c : this.getTeamController().getQueryManager().getAllCar()){
                if(t.getTeamId() == c.getTeam()){
                    list.add(new TeamCarTable(t, c));
                }
            }
        }
        table.setItems(FXCollections.observableList(list));
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
    void onAddClick() {
        this.getTeamController().addTeam(inputName.getText(), inputHeadquarter.getText(), inputNationality.getText());
        this.getTeamController().addCar(inputCarName.getText(), inputPU.getText(), inputName.getText());
        initTeamTable();
    }

    private TeamController getTeamController() {
        return (TeamController) this.getController();
    }
}
