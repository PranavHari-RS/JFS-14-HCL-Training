package com.pgcrp.publicgrievancecomplaintredressalportal.service;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Employee;
import com.pgcrp.publicgrievancecomplaintredressalportal.repository.EmployeeRepository;

import java.util.*;

public class EmployeeService {

    private final EmployeeRepository repository = new EmployeeRepository();

    public void addEmployee(Employee employee) {
        repository.addEmployee(employee);
    }

    public Employee searchEmployee(int id) {
        return repository.findById(id);
    }

    public void departmentFrequency() {

        Map<String, Integer> frequency = new HashMap<>();

        for (Employee employee : repository.findAll()) {

            frequency.merge(
                    employee.getDepartment(),
                    1,
                    Integer::sum
            );
        }

        System.out.println("Department Frequency:");

        frequency.forEach((department, count) ->
                System.out.println(department + " : " + count));
    }

    public void departmentReport() {

        Map<String, List<Employee>> report = new TreeMap<>();

        for (Employee employee : repository.findAll()) {

            report.computeIfAbsent(
                    employee.getDepartment(),
                    k -> new ArrayList<>()
            ).add(employee);
        }

        report.forEach((department, employees) -> {

            System.out.println("\nDepartment: " + department);

            employees.forEach(System.out::println);
        });
    }

    public void sortById() {

        List<Employee> employees = repository.findAll();

        Collections.sort(employees);

        employees.forEach(System.out::println);
    }

    public void topFiveSalary() {

        List<Employee> employees = repository.findAll();

        employees.sort(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName)
                        .thenComparingInt(Employee::getId)
        );

        System.out.println("Top 5 Highest Paid Employees:");

        employees.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}