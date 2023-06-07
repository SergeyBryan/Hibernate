package com.example.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Persistence {

    static EntityManagerFactory entityManagerFactory = jakarta.persistence.Persistence.createEntityManagerFactory("myPersistenceUnit");

    public static EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }
}
