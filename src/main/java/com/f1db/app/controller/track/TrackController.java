package com.f1db.app.controller.track;

import com.f1db.app.controller.Controller;

public interface TrackController extends Controller {
    void addTrack(String name, String country, String city, String length);
}
