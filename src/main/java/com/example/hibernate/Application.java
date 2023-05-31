package com.example.hibernate;

import com.example.hibernate.DAO.EmployeeDAOImpl;
import com.example.hibernate.entity.Employee;

public class Application {

    public static void main(String[] args) {
        Employee employee = new Employee();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employee.setAge(22);
        employee.setGender("male");
        employee.setLastName("Lara");
        employee.setFirstName("Croft");
        employee.setCityId(1);
        employeeDAO.deleteEmployee(employeeDAO.getAllEmployee().get(1), employeeDAO.getAllEmployee().get(1).getId());
        System.out.println(employeeDAO.getAllEmployee());
        Employee updatedEmployee = employeeDAO.getAllEmployee().get(1);
        updatedEmployee.setAge(25);
        employeeDAO.updateEmployee(updatedEmployee, employeeDAO.getAllEmployee().get(1).getId());
        employeeDAO.addEmployee(employee);
        System.out.println(employeeDAO.getEmployeeById(employeeDAO.getAllEmployee().get(1).getId()));
    }
}
