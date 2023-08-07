package com.f1db.app.view.driver;

import com.f1db.app.controller.driver.DriverController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Driver;
import com.f1db.entity.Engineer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DriverView extends AbstractFXView {

    @FXML
    private MenuButton driver1;

    @FXML
    private MenuButton driver2;

    @FXML
    private LineChart<?, ?> driverGraph;

    @FXML
    private ChoiceBox<String> engineer;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNationality;

    @FXML
    private TextField inputNumber;

    @FXML
    private TextField inputSurname;

    @FXML
    private TableColumn<Driver, String> nameColumn;

    @FXML
    private TableColumn<Driver, String> nationalityColumn;

    @FXML
    private TableColumn<Driver, Integer> numberColumn;

    @FXML
    private TableColumn<Driver, String> surnameColumn;

    @FXML
    private TableView<Driver> table;

    @Override
    public void init() {
        initDriverTable();
        initEngineerMenu();
    }

    private void initDriverTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        nameColumn.prefWidthProperty().bind(table.widthProperty().divide(4));
        surnameColumn.prefWidthProperty().bind(table.widthProperty().divide(4));
        numberColumn.prefWidthProperty().bind(table.widthProperty().divide(4));
        nationalityColumn.prefWidthProperty().bind(table.widthProperty().divide(4));
        ObservableList<Driver> drivers = FXCollections.observableArrayList(this.getDriverController().getAllDriver());
        table.setItems(drivers);

    }

    private void initEngineerMenu() {
        List<Engineer> engList = this.getDriverController().getQueryManager().getAllEngineer();
        List<String> surnameList = new ArrayList<>();

        engList.forEach(e -> surnameList.add(e.getSurname()));
        engineer.setItems(FXCollections.observableList(surnameList));
    }

    @FXML
    void onAddButton() {
        int engId = 0;
        for (var eng : this.getDriverController().getQueryManager().getAllEngineer()) {
            if(eng.getSurname().equals(engineer.getValue())){
                engId = eng.getEngineerId();
            }
        }
        this.getDriverController().addDriver(inputName.getText(), inputSurname.getText(), inputNationality.getText(),
                Integer.parseInt(inputNumber.getText()), engId);
    }

    @FXML
    void onAddEngineerClick() {
        //Open a new Stage with the page where you can add the engineer
        SceneManager.getInstance().switchPage(new Stage(), Pages.ENGINEER);
    }

    @FXML
    private void onEngineerClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.ENGINEER);
    }

    @FXML
    private void onRaceClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.RACE);
    }

    @FXML
    private void onTeamClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.TEAM);
    }
    private DriverController getDriverController() {
        return (DriverController) this.getController();
    }
}

