package com.f1db.app.view.track;

import com.f1db.app.controller.track.TrackController;
import com.f1db.app.view.AbstractFXView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TrackView extends AbstractFXView {
    @FXML
    private TextField inputCity;

    @FXML
    private TextField inputCountry;

    @FXML
    private TextField inputLength;

    @FXML
    private TextField inputName;

    @Override
    public void init() {

    }

    @FXML
    void onAddClick() {
        this.getTrackController().addTrack(inputName.getText(), inputCountry.getText(), inputCity.getText(), inputLength.getText());
        this.getStage().close();
    }

    private TrackController getTrackController() {
        return (TrackController) this.getController();
    }

}
