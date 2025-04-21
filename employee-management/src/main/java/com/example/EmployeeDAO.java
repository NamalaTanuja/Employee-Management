package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {
    private SessionFactory factory;

    public EmployeeDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void saveEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public void updateEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    public void deleteEmployee(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
        }
        transaction.commit();
        session.close();
    }

    public Employee getEmployee(int id) {
        Session session = factory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public List<Employee> getAllEmployees() {
        Session session = factory.openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return employees;
    }
}
