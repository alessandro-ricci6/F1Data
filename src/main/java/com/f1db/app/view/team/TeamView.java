package com.f1db.app.view.team;

import com.f1db.app.controller.team.TeamController;
import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.*;
import javafx.collections.FXCollections;
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

    @FXML
    private TableColumn<?, ?> directorNameColumn;

    @FXML
    private TableColumn<?, ?> directorNationalityColumn;

    @FXML
    private TableColumn<?, ?> roleColumn;

    @FXML
    private TableColumn<?, ?> surnameColumn;

    @FXML
    private TableView<?> directorTable;

    @FXML
    private TextField dirNameInput;

    @FXML
    private TextField dirNatInput;

    @FXML
    private ChoiceBox<String> dirRoleInput;

    @FXML
    private TextField dirSurnInput;

    @FXML
    private ChoiceBox<String> dirTeamInput;


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
        table.setItems(FXCollections.observableList(this.getTeamController().getTeamTable()));
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
    void onAddDirClick(){
        this.getTeamController().addDir(dirNameInput.getText(), dirSurnInput.getText(), dirNatInput.getText(),
                dirRoleInput.getValue(), dirTeamInput.getValue());
        init();
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
