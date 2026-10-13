package com.pgcrp.publicgrievancecomplaintredressalportal.demo;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Employee;
import com.pgcrp.publicgrievancecomplaintredressalportal.service.EmployeeService;

public class EmployeeDirectoryDemo {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        service.addEmployee(new Employee(105, "Arun", "IT", 45000));
        service.addEmployee(new Employee(102, "Bala", "HR", 35000));
        service.addEmployee(new Employee(108, "Charan", "Finance", 65000));
        service.addEmployee(new Employee(101, "David", "IT", 55000));
        service.addEmployee(new Employee(106, "Elan", "HR", 40000));
        service.addEmployee(new Employee(103, "Farhan", "Finance", 70000));
        service.addEmployee(new Employee(104, "Gokul", "IT", 60000));

        System.out.println("===== HASHMAP LOOKUP =====");

        System.out.println(service.searchEmployee(101));

        System.out.println("\n===== DEPARTMENT FREQUENCY =====");

        service.departmentFrequency();

        System.out.println("\n===== TREEMAP DEPARTMENT REPORT =====");

        service.departmentReport();

        System.out.println("\n===== SORT EMPLOYEES BY ID =====");

        service.sortById();

        System.out.println("\n===== TOP 5 SALARY =====");

        service.topFiveSalary();
    }
}