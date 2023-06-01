package com.example.hibernate;

import com.example.hibernate.DAO.CityDAOImpl;
import com.example.hibernate.DAO.EmployeeDAOImpl;
import com.example.hibernate.entity.City;
import com.example.hibernate.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Employee employee = new Employee();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();
        City city = new City();
        city.setCityName("Kazan");
        employee.setAge(20);
        employee.setGender("female");
        employee.setFirstName("Anna");
        employee.setLastName("Kuznetsova");
        employee.setCity(city);
        List<Employee> employeeList = new ArrayList<>(List.of(employee));
        city.setEmployeeList(employeeList);
        cityDAO.create(city);
        city.setCityName("Perm");
        city.getEmployeeList().get(0).setFirstName("Maria");
        System.out.println(cityDAO.getAllCities().get(1).getCityId());
        cityDAO.updateCity(city, cityDAO.getAllCities().get(1).getCityId());
        System.out.println(cityDAO.getAllCities().get(1).getCityId());
        cityDAO.deleteCity(city, cityDAO.getAllCities().get(1).getCityId());
        cityDAO.deleteCity(city, cityDAO.getAllCities().get(1).getCityId());
        System.out.println(cityDAO.getAllCities());

        System.out.println(cityDAO.getCityById(5));
    }
}
