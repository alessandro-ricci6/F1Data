package com.f1db.app.view.standing;

import com.f1db.app.controller.standing.StandingController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.entity.Championship;
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
        for (int i = 1; i <= 20; i++){
            for(var d : this.getStandingController().getQueryManager().getAllDriver()){
                if(getChoiceBox(i).getValue().equals(d.getSurname() + " " +d.getName())){
                    this.getStandingController().addStanding(d, i);
                }
            }
        }
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
        return switch (position) {
            case 1 -> position1;
            case 2 -> position2;
            case 3 -> position3;
            case 4 -> position4;
            case 5 -> position5;
            case 6 -> position6;
            case 7 -> position7;
            case 8 -> position8;
            case 9 -> position9;
            case 10 -> position10;
            case 11 -> position11;
            case 12 -> position12;
            case 13 -> position13;
            case 14 -> position14;
            case 15 -> position15;
            case 16 -> position16;
            case 17 -> position17;
            case 18 -> position18;
            case 19 -> position19;
            case 20 -> position20;
            default -> null;
        };
    }

    private StandingController getStandingController(){
        return (StandingController) this.getController();
    }
}
