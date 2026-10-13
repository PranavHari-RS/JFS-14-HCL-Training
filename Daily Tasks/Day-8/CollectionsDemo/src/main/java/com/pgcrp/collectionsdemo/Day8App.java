package com.pgcrp.collectionsdemo;

import com.pgcrp.collectionsdemo.demo.HashCodeBugDemo;
import com.pgcrp.collectionsdemo.model.Employee;
import com.pgcrp.collectionsdemo.repository.EmployeeRepository;
import com.pgcrp.collectionsdemo.service.EmployeeService;

public class Day8App {

    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepository();

        EmployeeService service = new EmployeeService(repository);

        service.addEmployee(new Employee(101, "Pranav", "IT", 75000));
        service.addEmployee(new Employee(102, "Arun", "HR", 55000));
        service.addEmployee(new Employee(103, "Kavin", "IT", 85000));
        service.addEmployee(new Employee(104, "Rahul", "Finance", 65000));
        service.addEmployee(new Employee(105, "Vijay", "IT", 95000));
        service.addEmployee(new Employee(106, "Ajay", "HR", 60000));
        service.addEmployee(new Employee(107, "Sanjay", "Finance", 70000));

        System.out.println("===== EMPLOYEE DIRECTORY =====");

        System.out.println("\n1. HashMap Lookup");

        System.out.println(service.searchEmployee(103));

        System.out.println("\n2. Department Frequency");

        service.departmentFrequency().forEach(
                (department, count) ->
                        System.out.println(department + " : " + count)
        );

        System.out.println("\n3. TreeMap Department Report");

        service.departmentReport().forEach(
                (department, employees) -> {

                    System.out.println("\nDepartment: " + department);

                    employees.forEach(System.out::println);
                }
        );

        System.out.println("\n4. Comparable - Sort by ID");

        service.sortById().forEach(System.out::println);

        System.out.println("\n5. Top 5 Highest Salaries");

        service.topFiveSalaries().forEach(System.out::println);

        HashCodeBugDemo.run();

        System.out.println("\n===== DAY 8 COMPLETED =====");
    }
}