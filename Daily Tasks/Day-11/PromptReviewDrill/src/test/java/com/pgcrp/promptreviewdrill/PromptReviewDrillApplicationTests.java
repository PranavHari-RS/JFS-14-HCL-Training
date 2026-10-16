package com.pgcrp.promptreviewdrill;

import com.pgcrp.promptreviewdrill.model.Student;
import com.pgcrp.promptreviewdrill.service.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromptReviewDrillApplicationTests {

    @Test
    void testAddAndFindStudent() {
        StudentService service = new StudentService();

        Student student = new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        );

        service.addStudent(student);

        assertEquals("Arun", service.getStudentById(101).getName());
    }

    @Test
    void testDuplicateStudentId() {
        StudentService service = new StudentService();

        Student student = new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        );

        service.addStudent(student);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addStudent(student)
        );
    }

    @Test
    void testInvalidStudentId() {
        StudentService service = new StudentService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.getStudentById(-1)
        );
    }

    @Test
    void testStudentNotFound() {
        StudentService service = new StudentService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.getStudentById(999)
        );
    }

    @Test
    void testInvalidUpdateId() {
        StudentService service = new StudentService();

        service.addStudent(new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        ));

        Student updated = new Student(
                102, "Kumar", "kumar@gmail.com", 21, 90.0
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.updateStudent(101, updated)
        );
    }

    @Test
    void testDefensiveCopy() {
        StudentService service = new StudentService();

        service.addStudent(new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        ));

        Student retrieved = service.getAllStudents().get(0);

        retrieved.setName("Changed Name");

        assertEquals(
                "Arun",
                service.getStudentById(101).getName()
        );
    }

    @Test
    void testIncompleteStudent() {
        StudentService service = new StudentService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addStudent(new Student())
        );
    }

    @Test
    void testUpdateStudent() {
        StudentService service = new StudentService();

        service.addStudent(new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        ));

        Student updated = new Student(
                101, "Arun Kumar", "arun@gmail.com", 20, 95.0
        );

        assertTrue(service.updateStudent(101, updated));

        assertEquals(
                "Arun Kumar",
                service.getStudentById(101).getName()
        );
    }

    @Test
    void testDeleteStudent() {
        StudentService service = new StudentService();

        service.addStudent(new Student(
                101, "Arun", "arun@gmail.com", 20, 85.5
        ));

        assertTrue(service.deleteStudent(101));

        assertTrue(service.getAllStudents().isEmpty());
    }
}