package com.pgcrp.publicgrievancecomplaintredressalportal.model;
import com.pgcrp.publicgrievancecomplaintredressalportal.common.BaseEntity;

public class Complaint extends BaseEntity{

    private String complaintId;
    private String citizenId;
    private String category;
    private String description;
    private String location;
    private String status;
    private String priority;
    private String assignedWorkerId;
    private boolean escalated;
    private int rating;

    public Complaint() {
    }

    public Complaint(String complaintId, String citizenId, String category,
                     String description, String location, String status,
                     String priority, String assignedWorkerId,
                     boolean escalated, int rating) {
        this.complaintId = complaintId;
        this.citizenId = citizenId;
        this.category = category;
        this.description = description;
        this.location = location;
        this.status = status;
        this.priority = priority;
        this.assignedWorkerId = assignedWorkerId;
        this.escalated = escalated;
        this.rating = rating;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignedWorkerId() {
        return assignedWorkerId;
    }

    public void setAssignedWorkerId(String assignedWorkerId) {
        this.assignedWorkerId = assignedWorkerId;
    }

    public boolean isEscalated() {
        return escalated;
    }

    public void setEscalated(boolean escalated) {
        this.escalated = escalated;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId='" + complaintId + '\'' +
                ", citizenId='" + citizenId + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", assignedWorkerId='" + assignedWorkerId + '\'' +
                ", escalated=" + escalated +
                ", rating=" + rating +
                '}';
    }
}