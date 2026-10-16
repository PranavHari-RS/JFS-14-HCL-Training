package com.pgcrp.promptreviewdrill;

import com.pgcrp.promptreviewdrill.model.Student;
import com.pgcrp.promptreviewdrill.service.StudentService;

public class PromptReviewDrillApplication {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student student1 = new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        );

        Student student2 = new Student(
                102, "Kumar", "kumar@gmail.com", 21, 90.0
        );

        service.addStudent(student1);
        service.addStudent(student2);

        System.out.println("===== ALL STUDENTS =====");
        service.getAllStudents().forEach(System.out::println);

        System.out.println("\n===== FIND STUDENT =====");
        System.out.println(service.getStudentById(101));

        System.out.println("\n===== UPDATE STUDENT =====");

        Student updated = new Student(
                101, "Arun Kumar", "arunkumar@gmail.com", 20, 95.0
        );

        service.updateStudent(101, updated);
        System.out.println(service.getStudentById(101));

        System.out.println("\n===== DELETE STUDENT =====");
        System.out.println("Deleted: " + service.deleteStudent(102));

        System.out.println("\n===== TEST DUPLICATE ID =====");

        try {
            service.addStudent(updated);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        }

        System.out.println("\n===== TEST INVALID ID =====");

        try {
            service.getStudentById(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        }

        System.out.println("\n===== TEST STUDENT NOT FOUND =====");

        try {
            service.getStudentById(999);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        }

        System.out.println("\n===== TEST INVALID UPDATE ID =====");

        try {
            Student wrongUpdate = new Student(
                    103, "Test", "test@gmail.com", 20, 80.0
            );

            service.updateStudent(101, wrongUpdate);

        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        }

        System.out.println("\n===== TEST DEFENSIVE COPY =====");

        Student retrieved = service.getAllStudents().get(0);
        retrieved.setName("Changed Name");

        if (!service.getStudentById(101).getName()
                .equals("Changed Name")) {
            System.out.println("PASS: Stored student was not modified.");
        } else {
            System.out.println("FAIL: Stored student was modified.");
        }

        System.out.println("\n===== TEST INCOMPLETE STUDENT =====");

        try {
            service.addStudent(new Student());
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        }
    }
}