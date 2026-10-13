package com.pgcrp.publicgrievancecomplaintredressalportal.service;

import com.pgcrp.publicgrievancecomplaintredressalportal.comparator.ComplaintPriorityComparator;
import com.pgcrp.publicgrievancecomplaintredressalportal.comparator.ComplaintStatusComparator;
import com.pgcrp.publicgrievancecomplaintredressalportal.exception.ComplaintNotFoundException;
import com.pgcrp.publicgrievancecomplaintredressalportal.exception.InvalidComplaintException;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;
import com.pgcrp.publicgrievancecomplaintredressalportal.repository.ComplaintRepository;
import com.pgcrp.publicgrievancecomplaintredressalportal.strategy.ComplaintRoutingStrategy;

import java.util.*;

public class ComplaintService {

    private final ComplaintRepository repository = new ComplaintRepository();

    private final Map<String, FieldWorker> workerMap = new HashMap<>();

    private final List<FieldWorker> workers = new ArrayList<>();

    private int complaintCounter = 1;

    public ComplaintService() {

        addWorker(new FieldWorker(
                "W001", "Ravi", "Road", "9876543210", true));

        addWorker(new FieldWorker(
                "W002", "Kumar", "Water", "9876543211", true));

        addWorker(new FieldWorker(
                "W003", "Arun", "Electricity", "9876543212", true));
    }

    private void addWorker(FieldWorker worker) {

        workerMap.put(worker.getWorkerId(), worker);

        workers.add(worker);
    }

    public FieldWorker findWorkerById(String workerId) {
        return workerMap.get(workerId);
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

        Complaint complaint = getComplaintOrThrow(complaintId);

        if (!"ROUTED".equals(complaint.getStatus())) {

            System.out.println(
                    "Complaint must be routed before assignment.");

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

    private Complaint getComplaintOrThrow(String complaintId) {

        Complaint complaint = repository.findById(complaintId);

        if (complaint == null) {
            throw new ComplaintNotFoundException(
                    "Complaint not found: " + complaintId);
        }

        return complaint;
    }

    public boolean complaintExists(String complaintId) {
        return repository.complaintExists(complaintId);
    }

    public void updateComplaintStatus(String complaintId, String newStatus) {

        Complaint complaint = getComplaintOrThrow(complaintId);

        if (newStatus == null || newStatus.isBlank()) {
            throw new InvalidComplaintException(
                    "Complaint status cannot be empty.");
        }

        String status = newStatus.trim().toUpperCase();

        Set<String> validStatuses = Set.of(
                "REGISTERED",
                "ROUTED",
                "ASSIGNED",
                "IN_PROGRESS",
                "RESOLVED"
        );

        if (!validStatuses.contains(status)) {
            throw new InvalidComplaintException(
                    "Invalid complaint status: " + newStatus);
        }

        complaint.setStatus(status);

        System.out.println("Complaint status updated successfully!");
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("New Status: " + status);
    }

    public void escalateComplaint(String complaintId) {

        Complaint complaint = getComplaintOrThrow(complaintId);

        if (complaint.isEscalated()) {
            System.out.println("Complaint is already escalated.");
            return;
        }

        if ("RESOLVED".equals(complaint.getStatus())) {
            System.out.println("Resolved complaints cannot be escalated.");
            return;
        }

        complaint.setEscalated(true);
        complaint.setPriority("HIGH");

        System.out.println("Complaint escalated successfully!");
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Priority: HIGH");
    }

    public void trackComplaint(String complaintId) {

        Complaint complaint = getComplaintOrThrow(complaintId);

        System.out.println("\n===== COMPLAINT DETAILS =====");

        System.out.println("Complaint ID: " + complaint.getComplaintId());
        System.out.println("Citizen ID: " + complaint.getCitizenId());
        System.out.println("Category: " + complaint.getCategory());
        System.out.println("Description: " + complaint.getDescription());
        System.out.println("Location: " + complaint.getLocation());
        System.out.println("Status: " + complaint.getStatus());
        System.out.println("Priority: " + complaint.getPriority());
        System.out.println("Assigned Worker: " + complaint.getAssignedWorkerId());
        System.out.println("Escalated: " + complaint.isEscalated());
    }

    public void displaySortedReport() {

        System.out.println("\n===== SORTED COMPLAINT REPORT =====");

        repository.getSortedComplaintReport().forEach(
                (id, complaint) -> System.out.println(complaint)
        );
    }

    public void displayPriorityReport() {

        List<Complaint> complaints =
                new ArrayList<>(repository.getAllComplaints());

        complaints.sort(new ComplaintPriorityComparator());

        System.out.println("\n===== PRIORITY SORTED REPORT =====");

        complaints.forEach(System.out::println);
    }

    public void displayStatusReport() {

        List<Complaint> complaints =
                new ArrayList<>(repository.getAllComplaints());

        complaints.sort(new ComplaintStatusComparator());

        System.out.println("\n===== STATUS SORTED REPORT =====");

        complaints.forEach(System.out::println);
    }
}