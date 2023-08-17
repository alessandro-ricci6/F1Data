package com.f1db.app.view.pages;


import com.f1db.app.controller.Controller;
import com.f1db.app.controller.championship.ChampionshipControllerImpl;
import com.f1db.app.controller.driver.DriverControllerImpl;
import com.f1db.app.controller.engineer.EngineerControllerImpl;
import com.f1db.app.controller.race.RaceControllerImpl;
import com.f1db.app.controller.standing.StandingControllerImpl;
import com.f1db.app.controller.team.TeamControllerImpl;
import com.f1db.app.controller.track.TrackControllerImpl;

/**
 * Enum containing all availbale pages.
 */
public enum Pages {
    CHAMPIONSHIP("ChampionshipView.fxml", new ChampionshipControllerImpl()),
    TRACK("TrackView.fxml", new TrackControllerImpl()),
    TEAM("TeamView.fxml", new TeamControllerImpl()),
    STANDING("StandingView.fxml", new StandingControllerImpl()),
    RACE("RaceView.fxml", new RaceControllerImpl()),
    ENGINEER("EngineerView.fxml", new EngineerControllerImpl()),
    DRIVER("DriverView.fxml", new DriverControllerImpl());
    private final String name;

    private final Controller controller;

    /**
     * @param name       of the view.
     * @param controller the associated to the view.
     */
    Pages(final String name, final Controller controller) {
        this.name = name;
        this.controller = controller;
    }

    /**
     * @return the name of the view.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the controller of the view.
     */
    public Controller getController() {
        return this.controller;
    }
}
