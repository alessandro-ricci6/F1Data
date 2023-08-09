package com.f1db.app.view.engineer;

import com.f1db.app.controller.engineer.EngineerController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Driver;
import com.f1db.entity.Engineer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EngineerView extends AbstractFXView {

    @FXML
    private TableView<Object> table;

    @FXML
    private TableColumn<Driver, String> columnDriver;

    @FXML
    private TableColumn<Engineer, String> columnName;

    @FXML
    private TableColumn<Engineer, String> columnNationality;

    @FXML
    private TableColumn<Engineer, String> columnSurname;

    @FXML
    private TextField findInput;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNationality;

    @FXML
    private TextField inputSurname;

    @FXML
    void onAddClick() {
        Engineer engineer = new Engineer();
        engineer.setName(inputName.getText());
        engineer.setNationality(inputNationality.getText());
        engineer.setSurname(inputSurname.getText());
        this.getEngineerController().addEngineer(engineer);
    }

    @FXML
    void onDriverClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.DRIVER);
    }

    @FXML
    void onRaceClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.RACE);
    }

    @FXML
    void onTeamClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.TEAM);
    }

    @Override
    public void init() {

    }

    private void initEngineerTable() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnDriver.setCellValueFactory(new PropertyValueFactory<>("driver"));
        columnNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnName.prefWidthProperty().bind(table.widthProperty().divide(4));
        columnDriver.prefWidthProperty().bind(table.widthProperty().divide(4));
        columnNationality.prefWidthProperty().bind(table.widthProperty().divide(4));
        columnSurname.prefWidthProperty().bind(table.widthProperty().divide(4));

    }

    private EngineerController getEngineerController() {
        return (EngineerController) this.getController();
    }
}
