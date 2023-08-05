package com.f1db.app.view.driver;

import com.f1db.app.controller.driver.DriverController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Driver;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DriverView extends AbstractFXView {

    @FXML
    private MenuButton driver1;

    @FXML
    private MenuButton driver2;

    @FXML
    private LineChart<?, ?> driverGraph;

    @FXML
    private MenuButton engineer;

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

    @FXML
    void onAddButton() {
        //this.getDriverController()
    }

    @Override
    public void init() {

    }

    @FXML
    void onAddEngineerClick() {
        //Open a new Stage with the page where you can add the engineer
        SceneManager.getInstance().switchPage(new Stage(), Pages.ENGINEER);
    }

    private void initDriverTable() {
        nameColumn.setPrefWidth(table.getWidth()/4);
        surnameColumn.setPrefWidth(table.getWidth()/4);
        numberColumn.setPrefWidth(table.getWidth()/4);
        nationalityColumn.setPrefWidth(table.getWidth()/4);
    }

    @FXML
    private void onEngineerClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.ENGINEER);
    }

    @FXML
    private void onRaceClick() {

    }

    @FXML
    private void onTeamClick() {

    }
    private DriverController getDriverController() {
        return (DriverController) this.getController();
    }
}

