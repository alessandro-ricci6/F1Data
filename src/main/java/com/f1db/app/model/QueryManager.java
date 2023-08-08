package com.f1db.app.model;

import com.f1db.entity.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class QueryManager {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();

    //Method to get the list of all the Driver
    public List<Driver> getAllDriver() {
        return entityManager.createNativeQuery("SELECT * FROM driver", Driver.class)
                .getResultList();
    }

    //Method to add a driver
    public void addDriver(final String name, final String surname,
                          final String nationality, final int number, final int engineer) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO driver (name, surname, nationality, number, engineer_engineerId)" +
                "VALUES (:name, :surname, :nationality, :number, :engineer)", Driver.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("nationality", nationality)
                .setParameter("number", number)
                .setParameter("engineer", engineer)
                .executeUpdate();
        transaction.commit();
    }

    public void addEngineer(Engineer engineer) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO engineer (name, surname, nationality)" +
                "VALUES (:name, :surname, :nationality)", Engineer.class)
                .setParameter("name", engineer.getName())
                .setParameter("surname", engineer.getSurname())
                .setParameter("nationality", engineer.getNationality())
                .executeUpdate();
        transaction.commit();
    }

    public List<Engineer> getAllEngineer() {
        return entityManager.createNativeQuery("SELECT * FROM engineer", Engineer.class)
                .getResultList();
    }

    public List<Contract> getAllContract(){
        return entityManager.createNativeQuery("SELECT * FROM contract", Contract.class)
                .getResultList();
    }

    public void addChampionship(int year) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO championship (year) VALUES (:year)")
                .setParameter("year", year)
                .executeUpdate();
        transaction.commit();
    }

    public List<Championship> getAllChampionship(){
        return entityManager.createNativeQuery("SELECT * FROM championship", Championship.class)
                .getResultList();
    }

    public void addStanding(Standing standing) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO standing (driver_driverId, race_raceId, position, points)" +
                "VALUES (:driverId, :raceId, :position, :points)")
                .setParameter("driverId", standing.getDriver())
                .setParameter("raceId", standing.getRace())
                .setParameter("position", standing.getPosition())
                .setParameter("points", standing.getPoints())
                .executeUpdate();
        transaction.commit();
    }

    public void addRace(Race race) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO race (laps, round, track_trackId, championship_championshipId)" +
                "VALUES (:laps, :round, :track, :championship)")
                .setParameter("laps", race.getLaps())
                .setParameter("round", race.getRound())
                .setParameter("track", race.getTrack())
                .setParameter("championship", race.getChampionship())
                .executeUpdate();
        transaction.commit();
    }

    public void addTrack(Track track) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO track (name, country, city, length)" +
                "VALUES (:name, :country, :city, :length)")
                .setParameter("name", track.getName())
                .setParameter("country", track.getCountry())
                .setParameter("city", track.getCity())
                .setParameter("length", track.getLength())
                .executeUpdate();
        transaction.commit();
    }

    public List<Track> getAlltrack(){
        return entityManager.createNativeQuery("SELECT * FROM track", Track.class)
                .getResultList();
    }
}
