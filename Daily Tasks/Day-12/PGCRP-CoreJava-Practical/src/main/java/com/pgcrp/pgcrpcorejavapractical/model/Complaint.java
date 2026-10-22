package com.pgcrp.pgcrpcorejavapractical.model;

public class Complaint {

    private String complaintId;
    private String citizenId;
    private String category;
    private String description;
    private String location;
    private String status;

    public Complaint(String complaintId, String citizenId,
                     String category, String description, String location) {

        this.complaintId = complaintId;
        this.citizenId = citizenId;
        this.category = category;
        this.description = description;
        this.location = location;
        this.status = "REGISTERED";
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "\nComplaint ID: " + complaintId +
                "\nCitizen ID: " + citizenId +
                "\nCategory: " + category +
                "\nDescription: " + description +
                "\nLocation: " + location +
                "\nStatus: " + status;
    }
}