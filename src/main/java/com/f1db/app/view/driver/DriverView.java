package com.f1db.app.view.driver;

import com.f1db.app.controller.driver.DriverController;
import com.f1db.app.model.mixedTable.ContractTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.Driver;
import com.f1db.entity.Engineer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class DriverView extends AbstractFXView {

    @FXML
    private ChoiceBox<String> driver1;

    @FXML
    private ChoiceBox<String> driver2;

    @FXML
    NumberAxis xAxis = new NumberAxis();
    @FXML
    NumberAxis yAxis = new NumberAxis();
    XYChart.Series<Number, Number> driver1Series;
    XYChart.Series<Number, Number> driver2Series;

    @FXML
    private LineChart<Number, Number> driverGraph = new LineChart<>(xAxis, yAxis);

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
    @FXML
    private TableView<ContractTable> contractTable;

    @FXML
    private ChoiceBox<String> driverChoice;

    @FXML
    private TableColumn<ContractTable, String> contractDriverColumn;

    @FXML
    private TableColumn<ContractTable, Integer> expColumn;

    @FXML
    private ChoiceBox<String> teamChoice;

    @FXML
    private TextField inputYear;

    @FXML
    private TableColumn<ContractTable, String> teamColumn;

    @Override
    public void init() {
        initDriverTable();
        initEngineerMenu();
        initContractTable();
        initChoicesBox();
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

    private void initContractTable() {
        contractDriverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        expColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        contractDriverColumn.prefWidthProperty().bind(contractTable.widthProperty().divide(3));
        teamColumn.prefWidthProperty().bind(contractTable.widthProperty().divide(3));
        expColumn.prefWidthProperty().bind(contractTable.widthProperty().divide(3));
        contractTable.setItems(FXCollections.observableList(this.getDriverController().getContractTableList()));
    }

    private void initChoicesBox() {
        List<String> nameList = new ArrayList<>();
        this.getDriverController().getQueryManager().getAllTeam()
                .forEach(t -> nameList.add(t.getName()));
        teamChoice.setItems(FXCollections.observableList(nameList));

        List<String> surnameList = new ArrayList<>();
        this.getDriverController().getAllDriver()
                .forEach(d -> surnameList.add(d.getSurname()));
        driverChoice.setItems(FXCollections.observableList(surnameList));

        List<String> driverList = new ArrayList<>();
        this.getDriverController().getAllDriver()
                .forEach(d -> driverList.add(d.getSurname() + ", " + d.getName()));
        driver1.setItems(FXCollections.observableList(driverList));
        driver1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            driver2.setDisable(false);
            driver2.setItems(FXCollections.observableList(driverList));
            initDriver1Chart(newValue);
        });
        driver2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                initDriver2Chart(newValue));
        driver2.setDisable(true);
    }

    void initDriver1Chart(String driver) {
        driverGraph.getData().remove(driver1Series);
        List<Pair<Integer, Integer>> list = this.getDriverController().getDriverStanding(driver);
        XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
        dataSeries.setName(driver);
        for (var p : list){
            dataSeries.getData().add(new XYChart.Data<>(p.getKey(), p.getValue()));
        }
        driverGraph.getData().add(dataSeries);
        this.driver1Series = dataSeries;
    }

    void initDriver2Chart(String driver) {
        driverGraph.getData().remove(driver2Series);
        List<Pair<Integer, Integer>> list = this.getDriverController().getDriverStanding(driver);
        XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
        dataSeries.setName(driver);
        for (var p : list){
            dataSeries.getData().add(new XYChart.Data<>(p.getKey(), p.getValue()));
        }
        driverGraph.getData().add(dataSeries);
        this.driver2Series = dataSeries;
    }

    @FXML
    void onAddContractClick() {
        this.getDriverController()
                .addContract(driverChoice.getValue(), teamChoice.getValue(), Integer.parseInt(inputYear.getText()));
        initContractTable();
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
        initDriverTable();
    }

    @FXML
    void onAddEngineerClick() {
        //Open a new Stage with the page where you can add the engineer
        SceneManager.getInstance().switchPage(this.getStage(), Pages.ENGINEER);
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

