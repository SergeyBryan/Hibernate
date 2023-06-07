package com.example.hibernate.DAO;

import com.example.hibernate.Persistence;
import com.example.hibernate.entity.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void createEmployee(Employee employee) {
        EntityManager entityManager = Persistence.create();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateEmployee(Employee employee, long id) {
        EntityManager entityManager = Persistence.create();
        employee.setId(id);
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList;
        EntityManager entityManager = Persistence.create();
        employeeList = entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
        entityManager.close();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(long id) {
        EntityManager entityManager = Persistence.create();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }

    @Override
    public void deleteEmployee(Employee employee, long id) {
        EntityManager entityManager = Persistence.create();
        employee.setId(id);
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(employee));
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
