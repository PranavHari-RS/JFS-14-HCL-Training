package com.pgcrp.promptreviewdrill.model;

import java.util.regex.Pattern;

public class Student {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[^\\s@]+@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z]{2,}$");

    private int id;
    private String name;
    private String email;
    private int age;
    private double marks;

    public Student() {
    }

    public Student(int id, String name, String email, int age, double marks) {
        setId(id);
        setName(name);
        setEmail(email);
        setAge(age);
        setMarks(marks);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Email must contain a valid address and domain.");
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 16 || age > 100) {
            throw new IllegalArgumentException("Age must be between 16 and 100.");
        }
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be finite and between 0 and 100.");
        }
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}
