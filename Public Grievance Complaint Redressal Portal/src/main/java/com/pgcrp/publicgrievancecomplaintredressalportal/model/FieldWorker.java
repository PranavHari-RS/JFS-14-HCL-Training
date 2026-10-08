package com.pgcrp.publicgrievancecomplaintredressalportal.model;

public class FieldWorker {

    private String workerId;
    private String name;
    private String department;
    private String phoneNumber;
    private boolean available;

    public FieldWorker() {
    }

    public FieldWorker(String workerId, String name, String department,
                       String phoneNumber, boolean available) {
        this.workerId = workerId;
        this.name = name;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.available = available;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "FieldWorker{" +
                "workerId='" + workerId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", available=" + available +
                '}';
    }
}