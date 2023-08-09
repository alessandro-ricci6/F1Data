package com.f1db.app.view.team;

import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.*;
import com.f1db.entity.Car;
import com.f1db.entity.Team;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TeamView extends AbstractFXView {

    @FXML
    private TextField inputHeadquarter;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNationality;

    @FXML
    private ChoiceBox<?> driver1;

    @FXML
    private ChoiceBox<?> driver2;

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

    @Override
    public void init() {

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

    }
}
