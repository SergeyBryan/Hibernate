package com.example.hibernate.DAO;

import com.example.hibernate.entity.City;

import java.util.List;

public interface CityDAO {

    void create(City city);

    List<City> getAllCities();

    City getCityById(int id);

    void updateCity(City city, int id);

    void deleteCity(City city, int id);

}
