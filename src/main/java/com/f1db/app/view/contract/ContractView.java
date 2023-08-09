package com.f1db.app.view.contract;

import com.f1db.app.controller.contract.ContractController;
import com.f1db.app.model.mixedTable.ContractTable;
import com.f1db.app.view.AbstractFXView;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ContractView extends AbstractFXView {

    @FXML
    private TableView<ContractTable> contractTable;

    @FXML
    private ChoiceBox<String> driverChoice;

    @FXML
    private TableColumn<ContractTable, String> driverColumn;

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
        initTable();
        initChoiceBox();
    }

    private void initTable() {
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        expColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        driverColumn.prefWidthProperty().bind(contractTable.widthProperty().divide(3));
        teamColumn.prefWidthProperty().bind(contractTable.widthProperty().divide(3));
        expColumn.prefWidthProperty().bind(contractTable.widthProperty().divide(3));
    }

    private void initChoiceBox() {
        List<String> nameList = new ArrayList<>();
        this.getContractController().getQueryManager().getAllTeam()
                .forEach(t -> nameList.add(t.getName()));
        teamChoice.setItems(FXCollections.observableList(nameList));
    }

    @FXML
    void onAddClick() {

    }

    private ContractController getContractController() {
        return (ContractController) this.getController();
    }
}
