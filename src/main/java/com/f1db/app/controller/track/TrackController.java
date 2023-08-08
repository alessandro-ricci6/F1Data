package com.f1db.app.controller.track;

import com.f1db.app.controller.Controller;
import com.f1db.entity.Track;

public interface TrackController extends Controller {
    void addTrack(Track track);
}
