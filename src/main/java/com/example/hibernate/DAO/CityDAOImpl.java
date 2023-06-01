package com.example.hibernate.DAO;

import com.example.hibernate.Persistence;
import com.example.hibernate.entity.City;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void create(City city) {
        EntityManager entityManager = Persistence.create();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<City> getAllCities() {
        EntityManager entityManager = Persistence.create();
        List<City> cityList = entityManager.createQuery("SELECT C FROM City C").getResultList();
        entityManager.close();
        return cityList;
    }

    @Override
    public City getCityById(int id) {
        EntityManager entityManager = Persistence.create();
        City city = entityManager.find(City.class, id);
        entityManager.close();
        return city;
    }

    @Override
    public void updateCity(City city, int id) {
        city.setCityId(id);
        EntityManager entityManager = Persistence.create();
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCity(City city, int id) {
        city.setCityId(id);
        EntityManager entityManager = Persistence.create();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(city));
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
