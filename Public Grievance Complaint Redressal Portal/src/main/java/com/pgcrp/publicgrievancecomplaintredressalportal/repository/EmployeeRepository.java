package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Employee;

import java.util.*;

public class EmployeeRepository {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public Employee findById(int id) {
        return employees.get(id);
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
}