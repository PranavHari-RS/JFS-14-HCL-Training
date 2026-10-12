package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;

import java.util.*;

public class ComplaintRepository {

    private final List<Complaint> complaints = new ArrayList<>();

    private final Set<String> complaintIds = new HashSet<>();

    private final Queue<Complaint> pendingComplaints = new ArrayDeque<>();

    public boolean saveComplaint(String complaintId, Complaint complaint) {

        if (complaintIds.contains(complaintId)) {
            return false;
        }

        complaints.add(complaint);
        complaintIds.add(complaintId);
        pendingComplaints.offer(complaint);

        return true;
    }

    public List<Complaint> getAllComplaints() {
        return Collections.unmodifiableList(complaints);
    }

    public Complaint getNextPendingComplaint() {
        return pendingComplaints.peek();
    }

    public Complaint removeNextPendingComplaint() {
        return pendingComplaints.poll();
    }

    public boolean complaintExists(String complaintId) {
        return complaintIds.contains(complaintId);
    }

    public int getComplaintCount() {
        return complaints.size();
    }

    public int getPendingCount() {
        return pendingComplaints.size();
    }
}