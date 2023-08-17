package com.f1db.app.view.engineer;

import com.f1db.app.controller.engineer.EngineerController;
import com.f1db.app.model.mixedTable.EngDriverTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.List;

public class EngineerView extends AbstractFXView {

    @FXML
    private TableView<EngDriverTable> table;

    @FXML
    private TableColumn<EngDriverTable, String> columnDriver;

    @FXML
    private TableColumn<EngDriverTable, String> columnName;

    @FXML
    private TableColumn<EngDriverTable, String> columnNationality;

    @FXML
    private TableColumn<EngDriverTable, String> columnSurname;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNationality;

    @FXML
    private TextField inputSurname;

    @FXML
    void onAddClick() {
        this.getEngineerController().addEngineer(inputName.getText(), inputSurname.getText(), inputNationality.getText());
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

    @FXML
    private void onChampionshipClick() {SceneManager.getInstance().switchPage(this.getStage(), Pages.CHAMPIONSHIP);}

    @Override
    public void init() {
        initEngineerTable();
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
        table.setItems(FXCollections.observableList(this.getEngineerController().getEngDriverTableList()));
    }

    private EngineerController getEngineerController() {
        return (EngineerController) this.getController();
    }
}
