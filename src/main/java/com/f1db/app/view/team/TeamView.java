package com.f1db.app.view.team;

import com.f1db.app.controller.team.TeamController;
import com.f1db.app.model.mixedTable.DirTeamTable;
import com.f1db.app.model.mixedTable.TeamCarTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.*;
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

    @FXML
    private TableColumn<DirTeamTable, String> directorNameColumn;

    @FXML
    private TableColumn<DirTeamTable, String> directorNationalityColumn;

    @FXML
    private TableColumn<DirTeamTable, String> dirTeamColumn;

    @FXML
    private TableColumn<DirTeamTable, String> roleColumn;

    @FXML
    private TableColumn<DirTeamTable, String> surnameColumn;

    @FXML
    private TableView<DirTeamTable> directorTable;

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
        initDirTable();
        initChoiceBox();
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

    private void initDirTable() {
        directorNameColumn.setCellValueFactory(new PropertyValueFactory<>("dirName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("dirSurname"));
        directorNationalityColumn.setCellValueFactory(new PropertyValueFactory<>("dirNationality"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        dirTeamColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        directorNameColumn.prefWidthProperty().bind(directorTable.widthProperty().divide(5));
        surnameColumn.prefWidthProperty().bind(directorTable.widthProperty().divide(5));
        directorNationalityColumn.prefWidthProperty().bind(directorTable.widthProperty().divide(5));
        roleColumn.prefWidthProperty().bind(directorTable.widthProperty().divide(5));
        dirTeamColumn.prefWidthProperty().bind(directorTable.widthProperty().divide(5));
        directorTable.setItems(FXCollections.observableList(this.getTeamController().getDirTable()));
    }

    private void initChoiceBox() {
        dirTeamInput.setItems(FXCollections.observableList(this.getTeamController().getTeamList()));
        List<String> roleList = new ArrayList<>();
        roleList.add("Team Principal");
        roleList.add("CEO");
        dirRoleInput.setItems(FXCollections.observableList(roleList));
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
        init();
    }

    private TeamController getTeamController() {
        return (TeamController) this.getController();
    }
}
