package com.f1db.app.model;

import com.f1db.entity.Driver;
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
        entityManager.createNativeQuery("INSERT INTO driver (name, surname, nationality, number, engineer)" +
                "VALUES (:name, :surname, :nationality, :number, :engineer)", Driver.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("nationality", nationality)
                .setParameter("number", number)
                .setParameter("engineer", engineer)
                .executeUpdate();
        transaction.commit();
    }
}
