package com.pgcrp.collectionsdemo.demo;

import com.pgcrp.collectionsdemo.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class HashCodeBugDemo {

    static class BuggyEmployee {

        private final int id;

        BuggyEmployee(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof BuggyEmployee)) {
                return false;
            }

            BuggyEmployee other = (BuggyEmployee) obj;

            return this.id == other.id;
        }
    }

    public static void run() {

        System.out.println("\n===== MISSING HASHCODE BUG =====");

        BuggyEmployee first = new BuggyEmployee(101);
        BuggyEmployee second = new BuggyEmployee(101);

        Set<BuggyEmployee> buggySet = new HashSet<>();

        buggySet.add(first);
        buggySet.add(second);

        System.out.println("Objects equal: " + first.equals(second));
        System.out.println("Buggy HashSet size: " + buggySet.size());

        System.out.println("\n===== FIXED HASHCODE =====");

        Employee employee1 =
                new Employee(101, "Pranav", "IT", 75000);

        Employee employee2 =
                new Employee(101, "Pranav", "IT", 75000);

        Set<Employee> fixedSet = new HashSet<>();

        fixedSet.add(employee1);
        fixedSet.add(employee2);

        System.out.println("Objects equal: " + employee1.equals(employee2));
        System.out.println("Fixed HashSet size: " + fixedSet.size());
    }
}