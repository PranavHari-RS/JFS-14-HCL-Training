package com.pgcrp.collectionsdemo.service;

import com.pgcrp.collectionsdemo.model.Employee;
import com.pgcrp.collectionsdemo.repository.EmployeeRepository;

import java.util.*;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee employee) {
        repository.addEmployee(employee);
    }

    public Employee searchEmployee(int id) {
        return repository.findById(id);
    }

    public Map<String, Integer> departmentFrequency() {

        Map<String, Integer> frequency = new HashMap<>();

        for (Employee employee : repository.findAll()) {

            frequency.merge(
                    employee.getDepartment(),
                    1,
                    Integer::sum
            );
        }

        return frequency;
    }

    public Map<String, List<Employee>> departmentReport() {

        Map<String, List<Employee>> report = new TreeMap<>();

        for (Employee employee : repository.findAll()) {

            report.computeIfAbsent(
                    employee.getDepartment(),
                    key -> new ArrayList<>()
            ).add(employee);
        }

        for (List<Employee> employees : report.values()) {
            Collections.sort(employees);
        }

        return report;
    }

    public List<Employee> sortById() {

        List<Employee> employees =
                new ArrayList<>(repository.findAll());

        Collections.sort(employees);

        return employees;
    }

    public List<Employee> topFiveSalaries() {

        List<Employee> employees =
                new ArrayList<>(repository.findAll());

        employees.sort(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName)
                        .thenComparingInt(Employee::getId)
        );

        return new ArrayList<>(
                employees.subList(0, Math.min(5, employees.size()))
        );
    }
}