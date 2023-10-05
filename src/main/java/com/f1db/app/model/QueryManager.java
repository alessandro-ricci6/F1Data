package com.f1db.app.model;

import com.f1db.entity.*;
import jakarta.persistence.*;

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

    public void addContract(Contract contract) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO contract (driver_driverId, team_teamId, expiration)" +
                "VALUES (:driver, :team, :expiration)")
                .setParameter("driver", contract.getDriver())
                .setParameter("team", contract.getTeam())
                .setParameter("expiration", contract.getExpiration())
                .executeUpdate();
        transaction.commit();
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

    public List<Standing> getStandingByRace (int raceId) {
        return entityManager.createNativeQuery("SELECT * FROM standing WHERE race_raceID= :raceId", Standing.class)
                .setParameter("raceId", raceId)
                .getResultList();
    }

    public List<Standing> getStandingByDriver(int driverId) {
        return entityManager.createNativeQuery("SELECT * FROM standing WHERE driver_driverId = :driverId", Standing.class)
                .setParameter("driverId", driverId)
                .getResultList();
    }

    public void addRace(Race race) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO race (laps, round, sprintRace, track_trackId, championship_championshipId)" +
                "VALUES (:laps, :round, :sprintRace, :track, :championship)")
                .setParameter("laps", race.getLaps())
                .setParameter("round", race.getRound())
                .setParameter("sprintRace", race.isSprintRace())
                .setParameter("track", race.getTrack())
                .setParameter("championship", race.getChampionship())
                .executeUpdate();
        transaction.commit();
    }

    public List<Race> getRaceByYear(int year) {
        return entityManager.createNativeQuery("SELECT * FROM race WHERE championship_championshipId = " +
                        "(SELECT championshipId FROM championship WHERE year = :year)", Race.class)
                .setParameter("year", year)
                .getResultList();
    }

    public List<Race> getAllRaces() {
        return entityManager.createNativeQuery("SELECT * FROM race", Race.class)
                .getResultList();
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

    public List<Track> getAllTrack(){
        return entityManager.createNativeQuery("SELECT * FROM track", Track.class)
                .getResultList();
    }

    public void addTeam(Team team) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO team (name, nationality, headquarter)" +
                "VALUES (:name, :nationality, :headquarter)")
                .setParameter("name", team.getName())
                .setParameter("nationality", team.getNationality())
                .setParameter("headquarter", team.getHeadquarter())
                .executeUpdate();
        transaction.commit();
    }

    public List<Team> getAllTeam() {
        return entityManager.createNativeQuery("SELECT * FROM team", Team.class)
                .getResultList();
    }

    public void addDirector(Director director) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO director (role, name, surname, nationality, team_teamId)" +
                "VALUES (:role, :name, :surname, :nationality, :team)")
                .setParameter("role", director.getRole())
                .setParameter("name", director.getName())
                .setParameter("surname", director.getSurname())
                .setParameter("nationality", director.getNationality())
                .setParameter("team", director.getTeam())
                .executeUpdate();
        transaction.commit();
    }

    public List<Director> getAlldirectors() {
        return entityManager.createNativeQuery("SELECT * FROM director", Director.class)
                .getResultList();
    }

    public void addCar(Car car) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO car (name, powerunit, team_teamId)" +
                "VALUES (:name, :powerunit, :team)")
                .setParameter("name", car.getCarName())
                .setParameter("powerunit", car.getPowerUnit())
                .setParameter("team", car.getTeam())
                .executeUpdate();
        transaction.commit();
    }

    public List<Car> getAllCar() {
        return entityManager.createNativeQuery("SELECT * FROM car", Car.class)
                .getResultList();
    }

    public Driver getDriverById(int driverId){
        return (Driver) entityManager.createNativeQuery("SELECT * FROM driver WHERE driverId = :id", Driver.class)
                .setParameter("id", driverId).getSingleResult();
    }

    public void updateContract (Contract contract) {
        transaction.begin();
        entityManager.createNativeQuery("UPDATE contract SET team_teamId = :teamId, expiration = :expiration " +
                "WHERE driver_driverId = :driverId")
                .setParameter("teamId", contract.getTeam())
                .setParameter("expiration", contract.getExpiration())
                .setParameter("driverId", contract.getDriver())
                .executeUpdate();
        transaction.commit();
    }

    public void deleteContract (Contract contract) {
        transaction.begin();
        entityManager.createNativeQuery("DELETE FROM contract WHERE team_teamId = :teamId and driver_driverId = :driverId")
                .setParameter("teamId", contract.getTeam())
                .setParameter("driverId", contract.getDriver())
                .executeUpdate();
        transaction.commit();
    }

}