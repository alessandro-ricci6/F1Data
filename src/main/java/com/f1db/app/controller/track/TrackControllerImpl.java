package com.f1db.app.controller.track;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Track;

public class TrackControllerImpl extends ControllerImpl implements TrackController {
    @Override
    public void addTrack(String name, String country, String city, String length) {
        Track track = new Track();
        track.setCity(city);
        track.setCountry(country);
        track.setLength(Integer.parseInt(length));
        track.setName(name);
        this.getQueryManager().addTrack(track);
    }
}
