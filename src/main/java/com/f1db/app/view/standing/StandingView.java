package com.f1db.app.view.standing;

import com.f1db.app.controller.standing.StandingController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.entity.Driver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;

public class StandingView extends AbstractFXView {

    @FXML
    private ChoiceBox<String> position1;

    @FXML
    private ChoiceBox<String> position10;

    @FXML
    private ChoiceBox<String> position11;

    @FXML
    private ChoiceBox<String> position12;

    @FXML
    private ChoiceBox<String> position13;

    @FXML
    private ChoiceBox<String> position14;

    @FXML
    private ChoiceBox<String> position15;

    @FXML
    private ChoiceBox<String> position16;

    @FXML
    private ChoiceBox<String> position17;

    @FXML
    private ChoiceBox<String> position18;

    @FXML
    private ChoiceBox<String> position19;

    @FXML
    private ChoiceBox<String> position2;

    @FXML
    private ChoiceBox<String> position20;

    @FXML
    private ChoiceBox<String> position3;

    @FXML
    private ChoiceBox<String> position4;

    @FXML
    private ChoiceBox<String> position5;

    @FXML
    private ChoiceBox<String> position6;

    @FXML
    private ChoiceBox<String> position7;

    @FXML
    private ChoiceBox<String> position8;

    @FXML
    private ChoiceBox<String> position9;

    @FXML
    private  ChoiceBox<String> fastLap;

    @FXML
    void onAddClick() {
        this.getStage().close();
    }

    @Override
    public void init() {
    initPos();
    }

    private void initPos () {
        List<Driver> driverList = this.getStandingController().getQueryManager().getAllDriver();
        List<String> inputList = new ArrayList<>();

        driverList.forEach(e -> inputList.add(e.getSurname() + " " + e.getName()));
        fastLap.setItems(FXCollections.observableList(inputList));
        for (int i = 1; i<=20; i++){
            getChoiceBox(i).setItems(FXCollections.observableList(inputList));
        }
    }

    private ChoiceBox<String> getChoiceBox(int position) {
        switch (position) {
            case 1:
                return position1;
            case 2:
                return position2;
            case 3:
                return position3;
            case 4:
                return position4;
            case 5:
                return position5;
            case 6:
                return position6;
            case 7:
                return position7;
            case 8:
                return position8;
            case 9:
                return position9;
            case 10:
                return position10;
            case 11:
                return position11;
            case 12:
                return position12;
            case 13:
                return position13;
            case 14:
                return position14;
            case 15:
                return position15;
            case 16:
                return position16;
            case 17:
                return position17;
            case 18:
                return position18;
            case 19:
                return position19;
            case 20:
                return position20;
            default:
                return null;
        }
    }

    private StandingController getStandingController(){
        return (StandingController) this.getController();
    }
}
