package com.pgcrp.publicgrievancecomplaintredressalportal.repository;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;

import java.util.*;

public class ComplaintRepository {

    private final Map<String, Complaint> complaints = new HashMap<>();

    private final Queue<Complaint> pendingComplaints = new ArrayDeque<>();

    public boolean saveComplaint(String complaintId, Complaint complaint) {

        if (complaints.containsKey(complaintId)) {
            return false;
        }

        complaints.put(complaintId, complaint);

        pendingComplaints.offer(complaint);

        return true;
    }

    public Collection<Complaint> getAllComplaints() {
        return Collections.unmodifiableCollection(complaints.values());
    }

    public Complaint findById(String complaintId) {
        return complaints.get(complaintId);
    }

    public boolean complaintExists(String complaintId) {
        return complaints.containsKey(complaintId);
    }

    public Complaint getNextPendingComplaint() {
        return pendingComplaints.peek();
    }

    public Complaint removeNextPendingComplaint() {
        return pendingComplaints.poll();
    }

    public int getComplaintCount() {
        return complaints.size();
    }

    public int getPendingCount() {
        return pendingComplaints.size();
    }

    public Map<String, Complaint> getSortedComplaintReport() {
        return Collections.unmodifiableMap(new TreeMap<>(complaints));
    }
}