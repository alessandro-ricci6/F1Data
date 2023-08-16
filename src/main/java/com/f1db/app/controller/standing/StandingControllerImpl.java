package com.f1db.app.controller.standing;

import com.f1db.app.controller.ControllerImpl;
import com.f1db.entity.Driver;
import com.f1db.entity.Race;
import com.f1db.entity.Standing;

import java.util.Comparator;
import java.util.stream.Collectors;

public class StandingControllerImpl extends ControllerImpl implements StandingController {
    @Override
    public void addStanding(Driver driver, int position, boolean fl) {
        Standing standing = new Standing();
        standing.setDriver(driver.getDriverId());
        Race lastRace = this.getQueryManager().getAllRaces().stream()
                .sorted(Comparator.comparingInt(Race::getRaceId).reversed())
                .toList().get(0);
        if(fl && lastRace.isSprintRace())
            standing.setPoints(getSprintPoint(position) + flPoint(position));
        else if (fl && !lastRace.isSprintRace())
            standing.setPoints(getPoint(position) + flPoint(position));
        else if (!fl && lastRace.isSprintRace())
            standing.setPoints(getSprintPoint(position));
        else standing.setPoints(getPoint(position));
        standing.setPosition(position);
        standing.setRace(this.getQueryManager().getAllRaces()
                .get(this.getQueryManager().getAllRaces().size() - 1).getRaceId());
        this.getQueryManager().addStanding(standing);
    }

    private double getPoint(int position) {
        switch (position) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            case 5: return 10;
            case 6: return 8;
            case 7: return 6;
            case 8: return 4;
            case 9: return 2;
            case 10: return 1;
            default: return 0;
        }
    }

    private double getSprintPoint(int position) {
        switch (position) {
            case 1: return 8;
            case 2: return 7;
            case 3: return 6;
            case 4: return 5;
            case 5: return 4;
            case 6: return 3;
            case 7: return 2;
            case 8: return 1;
            default: return 0;
        }
    }

    private double flPoint(int position) {
        if(position<=10 && position>=1){
            return 1;
        }
        return 0;
    }
}
