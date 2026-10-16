package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.ComplaintFeedback;

import java.util.List;
import java.util.Objects;

public class ComplaintFeedbackRepository
        extends InMemoryRepository<ComplaintFeedback, Long> {

    public ComplaintFeedbackRepository() {
        super(ComplaintFeedback::getId);
    }

    public List<ComplaintFeedback> findByComplaintId(String complaintId) {
        return findAll().stream()
                .filter(feedback -> Objects.equals(
                        feedback.getComplaintId(), complaintId
                ))
                .toList();
    }
}
