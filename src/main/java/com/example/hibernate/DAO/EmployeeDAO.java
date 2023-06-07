package com.example.hibernate.DAO;

import com.example.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee, long id);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    void deleteEmployee(Employee employee, long id);

}
