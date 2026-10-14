package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;

import java.util.*;

public class ComplaintRepository {

    private final InMemoryRepository<Complaint, String> repository =
            new InMemoryRepository<>(Complaint::getComplaintId);

    private final Queue<Complaint> pendingComplaints =
            new ArrayDeque<>();

    public boolean saveComplaint(String complaintId, Complaint complaint) {

        if (complaintId == null || complaint == null ||
                !complaintId.equals(complaint.getComplaintId())) {
            throw new IllegalArgumentException("Invalid complaint ID");
        }

        if (repository.existsById(complaintId)) {
            return false;
        }

        repository.save(complaint);

        if ("REGISTERED".equalsIgnoreCase(complaint.getStatus())
                || "OPEN".equalsIgnoreCase(complaint.getStatus())) {

            pendingComplaints.offer(complaint);
        }

        return true;
    }

    public Collection<Complaint> getAllComplaints() {
        return Collections.unmodifiableList(repository.findAll());
    }

    public Complaint findById(String complaintId) {
        return repository.findById(complaintId).orElse(null);
    }

    public boolean complaintExists(String complaintId) {
        return repository.existsById(complaintId);
    }

    public Complaint getNextPendingComplaint() {
        return pendingComplaints.peek();
    }

    public Complaint removeNextPendingComplaint() {
        return pendingComplaints.poll();
    }

    public int getComplaintCount() {
        return (int) repository.count();
    }

    public int getPendingCount() {
        return pendingComplaints.size();
    }

    public Map<String, Complaint> getSortedComplaintReport() {

        Map<String, Complaint> sorted = new TreeMap<>();

        for (Complaint complaint : repository.findAll()) {
            sorted.put(complaint.getComplaintId(), complaint);
        }

        return Collections.unmodifiableMap(sorted);
    }

    public Complaint updateComplaint(String complaintId, Complaint complaint) {
        return repository.update(complaintId, complaint);
    }

    public boolean deleteComplaint(String complaintId) {

        boolean deleted = repository.deleteById(complaintId);

        if (deleted) {
            pendingComplaints.removeIf(
                    complaint -> complaintId.equals(complaint.getComplaintId())
            );
        }

        return deleted;
    }
}