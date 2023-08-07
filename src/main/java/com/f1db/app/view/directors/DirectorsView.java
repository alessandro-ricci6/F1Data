package com.f1db.app.view.directors;

import com.f1db.app.view.AbstractFXView;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DirectorsView extends AbstractFXView {

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> nationalityColumn;

    @FXML
    private TableColumn<?, ?> roleColumn;

    @FXML
    private TableColumn<?, ?> surnameColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private ChoiceBox<?> teamSelection;

    @Override
    public void init() {

    }
}
