package com.pgcrp.collectionsdemo.repository;

import com.pgcrp.collectionsdemo.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public Employee findById(int id) {
        return employees.get(id);
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}