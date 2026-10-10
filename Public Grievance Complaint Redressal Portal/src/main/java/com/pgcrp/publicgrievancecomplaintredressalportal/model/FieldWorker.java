package com.pgcrp.publicgrievancecomplaintredressalportal.model;

public class FieldWorker extends User {

    private String workerId;
    private String department;
    private String phoneNumber;
    private boolean available;
    private int activeComplaintCount;

    /*public FieldWorker() {
        super();
        this.role = "FIELD_WORKER";
    }*/
    public FieldWorker(String name, String email) {
        super(name, email, "FIELD_WORKER");
    }

    public FieldWorker(String workerId, String name, String department,
                       String phoneNumber, boolean available) {
        super(name, null, "FIELD_WORKER");
        this.workerId = workerId;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.available = available;
        this.activeComplaintCount = 0;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
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

    public int getActiveComplaintCount() {
        return activeComplaintCount;
    }

    public void setActiveComplaintCount(int activeComplaintCount) {
        this.activeComplaintCount = activeComplaintCount;
    }

    @Override
    public void displayResponsibilities() {
        System.out.println("Can handle and resolve assigned complaints.");
    }

    @Override
    public String toString() {
        return "FieldWorker{" +
                "workerId='" + workerId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", available=" + available +
                ", activeComplaintCount=" + activeComplaintCount +
                '}';
    }

}
