package com.pgcrp.publicgrievancecomplaintredressalportal.demo;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class HashCodeBugDemo {

    static class BuggyEmployee {

        int id;
        String name;

        BuggyEmployee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (!(obj instanceof BuggyEmployee)) return false;

            BuggyEmployee other = (BuggyEmployee) obj;

            return this.id == other.id;
        }
    }

    public static void main(String[] args) {

        System.out.println("===== BEFORE FIX =====");

        Set<BuggyEmployee> buggySet = new HashSet<>();

        buggySet.add(new BuggyEmployee(101, "Arun"));
        buggySet.add(new BuggyEmployee(101, "Arun"));

        System.out.println("HashSet size: " + buggySet.size());

        System.out.println("\n===== AFTER FIX =====");

        Set<Employee> fixedSet = new HashSet<>();

        fixedSet.add(new Employee(101, "Arun", "IT", 45000));
        fixedSet.add(new Employee(101, "Arun", "IT", 45000));

        System.out.println("HashSet size: " + fixedSet.size());
    }
}