package com.f1db.app.view.track;

import com.f1db.app.controller.track.TrackController;
import com.f1db.app.view.AbstractFXView;
import com.f1db.entity.Track;
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
        Track track = new Track();
        track.setCity(inputCity.getText());
        track.setCountry(inputCountry.getText());
        track.setLength(Integer.parseInt(inputLength.getText()));
        track.setName(inputName.getText());
        this.getTrackController().addTrack(track);
        this.getStage().close();
    }

    private TrackController getTrackController() {
        return (TrackController) this.getController();
    }

}
