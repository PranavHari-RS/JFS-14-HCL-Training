package com.pgcrp.publicgrievancecomplaintredressalportal.model;

public class Citizen extends User {

    private String citizenId;
    private String phoneNumber;
    private String address;

    public Citizen() {
        super();
        this.role = "CITIZEN";
    }

    public Citizen(String citizenId, String name, String email,
                   String phoneNumber, String address) {
        super(name, email, "CITIZEN");
        this.citizenId = citizenId;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void displayResponsibilities() {
        System.out.println("Can file and track complaints.");
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId='" + citizenId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
