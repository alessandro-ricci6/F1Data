package com.f1db.app.controller.track;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Track;

public class TrackControllerImpl extends ControllerImpl implements TrackController {
    @Override
    public void addTrack(Track track) {
        this.getQueryManager().addTrack(track);
    }
}
