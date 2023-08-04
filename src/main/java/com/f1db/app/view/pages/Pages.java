package com.f1db.app.view.pages;


import com.f1db.app.controller.Controller;
import com.f1db.app.controller.driver.DriverControllerImpl;

/**
 * Enum containing all availbale pages.
 */
public enum Pages {
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
