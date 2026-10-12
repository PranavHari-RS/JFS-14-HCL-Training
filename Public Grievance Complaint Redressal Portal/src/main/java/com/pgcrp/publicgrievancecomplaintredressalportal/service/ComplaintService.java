package com.pgcrp.publicgrievancecomplaintredressalportal.service;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;
import com.pgcrp.publicgrievancecomplaintredressalportal.repository.ComplaintRepository;
import com.pgcrp.publicgrievancecomplaintredressalportal.exception.ComplaintNotFoundException;
import com.pgcrp.publicgrievancecomplaintredressalportal.strategy.ComplaintRoutingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ComplaintService {

    private final ComplaintRepository repository = new ComplaintRepository();

    private final List<FieldWorker> workers = new ArrayList<>();

    private int complaintCounter = 1;

    public ComplaintService() {

        workers.add(new FieldWorker(
                "W001", "Ravi", "Road", "9876543210", true));

        workers.add(new FieldWorker(
                "W002", "Kumar", "Water", "9876543211", true));

        workers.add(new FieldWorker(
                "W003", "Arun", "Electricity", "9876543212", true));
    }

    public void fileComplaint(String citizenId, String category,
                              String description, String location) {

        Complaint.validateDescription(description);

        String complaintId = String.format("C%03d", complaintCounter);

        Complaint complaint = new Complaint();

        complaint.setComplaintId(complaintId);
        complaint.setCitizenId(citizenId);
        complaint.setCategory(category);
        complaint.setDescription(description);
        complaint.setLocation(location);
        complaint.setStatus("REGISTERED");
        complaint.setPriority("NORMAL");

        boolean saved = repository.saveComplaint(complaintId, complaint);

        if (saved) {
            complaintCounter++;
            System.out.println("Complaint filed successfully!");
            System.out.println("Complaint ID: " + complaintId);
            System.out.println("Status: REGISTERED");
        } else {
            System.out.println("Duplicate complaint ID!");
        }
    }

    public void routeComplaint() {

        Complaint complaint = repository.getNextPendingComplaint();

        if (complaint == null) {
            System.out.println("No pending complaints.");
            return;
        }

        complaint.setStatus("ROUTED");

        repository.removeNextPendingComplaint();

        System.out.println("Complaint routed successfully!");
        System.out.println("Complaint ID: " + complaint.getComplaintId());
        System.out.println("Category: " + complaint.getCategory());
        System.out.println("Status: " + complaint.getStatus());
    }

    public void assignFieldWorker(String complaintId,
                                  ComplaintRoutingStrategy strategy) {

        Complaint complaint = null;

        for (Complaint c : repository.getAllComplaints()) {
            if (c.getComplaintId().equals(complaintId)) {
                complaint = c;
                break;
            }
        }

        if (complaint == null) {
            throw new ComplaintNotFoundException(
                    "Complaint not found: " + complaintId);
        }

        if (!"ROUTED".equals(complaint.getStatus())) {
            System.out.println("Complaint must be routed before assignment.");
            return;
        }

        FieldWorker worker = strategy.assignWorker(complaint, workers);

        if (worker == null) {
            System.out.println("No suitable field worker available.");
            return;
        }

        complaint.setAssignedWorkerId(worker.getWorkerId());
        complaint.setStatus("ASSIGNED");

        worker.setActiveComplaintCount(
                worker.getActiveComplaintCount() + 1);

        System.out.println("Field worker assigned successfully!");
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Worker ID: " + worker.getWorkerId());
        System.out.println("Status: ASSIGNED");
    }

    public boolean complaintExists(String complaintId) {
        return repository.complaintExists(complaintId);
    }
}