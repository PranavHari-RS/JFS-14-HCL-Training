package com.pgcrp.promptreviewdrill.service;

import com.pgcrp.promptreviewdrill.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    private void validateId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Student ID must be greater than 0."
            );
        }
    }

    private void validateStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null."
            );
        }

        validateId(student.getId());

        Student validated = new Student(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getMarks()
        );
    }

    private Student copyStudent(Student student) {
        return new Student(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getMarks()
        );
    }

    public void addStudent(Student student) {

        validateStudent(student);

        for (Student existing : students) {
            if (existing.getId() == student.getId()) {
                throw new IllegalArgumentException(
                        "Duplicate student ID: " + student.getId()
                );
            }
        }

        students.add(copyStudent(student));
    }

    public Student getStudentById(int id) {

        validateId(id);

        for (Student student : students) {
            if (student.getId() == id) {
                return copyStudent(student);
            }
        }

        throw new IllegalArgumentException(
                "Student not found with ID: " + id
        );
    }

    public List<Student> getAllStudents() {

        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            result.add(copyStudent(student));
        }

        return result;
    }

    public boolean updateStudent(int id, Student updatedStudent) {

        validateId(id);
        validateStudent(updatedStudent);

        if (id != updatedStudent.getId()) {
            throw new IllegalArgumentException(
                    "Student ID cannot be changed during update."
            );
        }

        for (int index = 0; index < students.size(); index++) {

            if (students.get(index).getId() == id) {

                students.set(index, copyStudent(updatedStudent));

                return true;
            }
        }

        return false;
    }

    public boolean deleteStudent(int id) {

        validateId(id);

        return students.removeIf(
                student -> student.getId() == id
        );
    }
}