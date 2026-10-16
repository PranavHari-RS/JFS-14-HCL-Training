package com.pgcrp.publicgrievancecomplaintredressalportal.model;

import com.pgcrp.publicgrievancecomplaintredressalportal.common.BaseEntity;

import java.time.LocalDateTime;

public class ComplaintFeedback extends BaseEntity {

    private String complaintId;
    private String citizenId;
    private int rating;
    private String feedbackComments;
    private LocalDateTime submittedAt;

    public ComplaintFeedback() {
        this.rating = 1;
        this.submittedAt = LocalDateTime.now();
    }

    public ComplaintFeedback(String complaintId, String citizenId, int rating,
                             String feedbackComments) {
        this.complaintId = complaintId;
        this.citizenId = citizenId;
        setRating(rating);
        this.feedbackComments = feedbackComments;
        this.submittedAt = LocalDateTime.now();
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        this.rating = rating;
    }

    public String getFeedbackComments() {
        return feedbackComments;
    }

    public void setFeedbackComments(String feedbackComments) {
        this.feedbackComments = feedbackComments;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
