package com.f1db.app.view.contract;

import com.f1db.app.view.AbstractFXView;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ContractView extends AbstractFXView {

    @FXML
    private TableView<?> contractTable;

    @FXML
    private ChoiceBox<?> driverChoice;

    @FXML
    private TableColumn<?, ?> driverColumn;

    @FXML
    private TableColumn<?, ?> expColumn;

    @FXML
    private ChoiceBox<?> teamChoice;

    @FXML
    private TableColumn<?, ?> teamColumn;

    @Override
    public void init() {

    }

    @FXML
    void onAddClick() {

    }
}
