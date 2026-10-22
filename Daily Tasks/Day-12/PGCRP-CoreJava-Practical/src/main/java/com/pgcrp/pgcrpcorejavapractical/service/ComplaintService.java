package com.pgcrp.pgcrpcorejavapractical.service;

import com.pgcrp.pgcrpcorejavapractical.model.Complaint;
import com.pgcrp.pgcrpcorejavapractical.exception.ComplaintNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ComplaintService {

    private final Map<String, Complaint> complaints = new HashMap<>();
    private int complaintCounter = 100;

    public Complaint fileComplaint(String citizenId, String category,
                                   String description, String location) {

        if (citizenId == null || citizenId.isBlank() ||
                category == null || category.isBlank() ||
                description == null || description.isBlank() ||
                location == null || location.isBlank()) {

            throw new IllegalArgumentException(
                    "Complaint details cannot be empty."
            );
        }

        String complaintId = "C" + (++complaintCounter);

        Complaint complaint = new Complaint(
                complaintId,
                citizenId,
                category,
                description,
                location
        );

        complaints.put(complaintId, complaint);

        return complaint;
    }

    public Complaint trackComplaint(String complaintId) {

        Complaint complaint = complaints.get(complaintId);

        if (complaint == null) {
            throw new ComplaintNotFoundException(
                    "Complaint not found: " + complaintId
            );
        }

        return complaint;
    }
}