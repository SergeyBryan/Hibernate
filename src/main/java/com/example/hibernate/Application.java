package com.example.hibernate;

import com.example.hibernate.DAO.CityDAOImpl;
import com.example.hibernate.entity.City;
import com.example.hibernate.entity.Employee;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        CityDAOImpl cityDAO = new CityDAOImpl();
        City city = createCity("Kazan");
        Employee employee = createEmployee("Anna", "Kuznetsova", 20, "female");
        List<Employee> employeeList = new ArrayList<>(List.of(employee));
        city.setEmployeeList(employeeList);
        cityDAO.create(city);
        System.out.println(cityDAO.getCityById(cityDAO.getAllCities().get(cityDAO.getAllCities().size() - 1).getCityId()));
        city.setCityName("Perm");
        city.getEmployeeList().get(0).setFirstName("Maria");
        cityDAO.updateCity(city, cityDAO.getCityById(cityDAO.getAllCities().get(cityDAO.getAllCities().size() - 1).getCityId()).getCityId());
        System.out.println(cityDAO.getCityById(cityDAO.getAllCities().size() - 1));
        cityDAO.deleteCity(city, cityDAO.getAllCities().get(1).getCityId());
        System.out.println(cityDAO.getAllCities());
    }

    private static City createCity(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        return city;
    }

    private static Employee createEmployee(String firstName, String lastName, int age, String gender) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setGender(gender);
        return employee;
    }
}
