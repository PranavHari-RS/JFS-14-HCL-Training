    package com.pgcrp.publicgrievancecomplaintredressalportal.service;

    import com.pgcrp.publicgrievancecomplaintredressalportal.exception.ComplaintNotFoundException;
    import com.pgcrp.publicgrievancecomplaintredressalportal.exception.InvalidComplaintException;
    import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
    import com.pgcrp.publicgrievancecomplaintredressalportal.model.FieldWorker;
    import com.pgcrp.publicgrievancecomplaintredressalportal.repository.ComplaintRepository;
    import com.pgcrp.publicgrievancecomplaintredressalportal.strategy.ComplaintRoutingStrategy;
    import com.pgcrp.publicgrievancecomplaintredressalportal.repository.CitizenRepository;
    import com.pgcrp.publicgrievancecomplaintredressalportal.repository.FieldWorkerRepository;
    import com.pgcrp.publicgrievancecomplaintredressalportal.sampledata.CsvDataLoader;
    import com.pgcrp.publicgrievancecomplaintredressalportal.model.ComplaintFeedback;
    import com.pgcrp.publicgrievancecomplaintredressalportal.repository.ComplaintFeedbackRepository;
    import java.time.LocalDateTime;
    import java.time.Duration;

    import java.util.*;
    
    public class ComplaintService {
    
        private final ComplaintRepository repository = new ComplaintRepository();
    
        private final CitizenRepository citizenRepository = new CitizenRepository();
    
        private final FieldWorkerRepository fieldWorkerRepository = new FieldWorkerRepository();
    
        private final Map<String, FieldWorker> workerMap = new HashMap<>();
    
        private final List<FieldWorker> workers = new ArrayList<>();
    
        private int complaintCounter = 1;

        private final ComplaintFeedbackRepository feedbackRepository =
                new ComplaintFeedbackRepository();

        private long feedbackCounter = 1;


        public ComplaintService() {
    
            System.out.println("\n===== LOADING CSV SEED DATA =====");
    
            CsvDataLoader.loadComplaints(repository);
    
            CsvDataLoader.loadCitizens(citizenRepository);
    
            CsvDataLoader.loadFieldWorkers(fieldWorkerRepository);
    
            for (FieldWorker worker : fieldWorkerRepository.findAll()) {
                addWorker(worker);
            }
    
            complaintCounter = repository.getAllComplaints()
                    .stream()
                    .map(Complaint::getComplaintId)
                    .filter(id -> id != null && id.matches("C\\d+"))
                    .mapToInt(id -> Integer.parseInt(id.substring(1)))
                    .max()
                    .orElse(0) + 1;
    
            System.out.println("\n===== DATA LOADED SUCCESSFULLY =====");
    
            System.out.println(
                    "Total Complaints: " + repository.getComplaintCount());
    
            System.out.println(
                    "Total Citizens: " + citizenRepository.count());
    
            System.out.println(
                    "Total Field Workers: " + fieldWorkerRepository.count());
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
            complaint.setCreatedAt(LocalDateTime.now());
    
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
                    "RESOLVED",
                    "REOPENED"
            );
    
            if (!validStatuses.contains(status)) {
                throw new InvalidComplaintException(
                        "Invalid complaint status: " + newStatus);
            }

            complaint.setStatus(status);

            if ("RESOLVED".equals(status)) {
                complaint.setResolvedAt(LocalDateTime.now());
            } else {
                complaint.setResolvedAt(null);
            }
    
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

            Map<String, Integer> priorityRank = Map.of(
                    "HIGH", 1,
                    "MEDIUM", 2,
                    "NORMAL", 3,
                    "LOW", 4
            );

            complaints.sort((c1, c2) -> {

                String p1 = c1.getPriority();
                String p2 = c2.getPriority();

                int rank1 = p1 == null ? 4 :
                        priorityRank.getOrDefault(p1.toUpperCase(), 5);

                int rank2 = p2 == null ? 4 :
                        priorityRank.getOrDefault(p2.toUpperCase(), 5);

                int result = Integer.compare(rank1, rank2);

                if (result != 0) {
                    return result;
                }

                return c1.getComplaintId().compareTo(c2.getComplaintId());
            });

            System.out.println("\n===== PRIORITY SORTED REPORT =====");

            complaints.forEach(System.out::println);
        }

        public void displayStatusReport() {

            List<Complaint> complaints =
                    new ArrayList<>(repository.getAllComplaints());

            complaints.sort((c1, c2) -> {

                int result = String.CASE_INSENSITIVE_ORDER.compare(
                        c1.getStatus(),
                        c2.getStatus()
                );

                if (result != 0) {
                    return result;
                }

                return c1.getComplaintId().compareTo(c2.getComplaintId());
            });

            System.out.println("\n===== STATUS SORTED REPORT =====");

            complaints.forEach(System.out::println);
        }

        public void rateComplaint(String complaintId, int rating, String comments) {

            Complaint complaint = getComplaintOrThrow(complaintId);

            if (!"RESOLVED".equals(complaint.getStatus())) {
                throw new InvalidComplaintException(
                        "Only resolved complaints can be rated."
                );
            }

            if (rating < 1 || rating > 5) {
                throw new InvalidComplaintException(
                        "Rating must be between 1 and 5."
                );
            }

            if (comments == null || comments.isBlank()) {
                throw new InvalidComplaintException(
                        "Feedback comments cannot be empty."
                );
            }

            if (!feedbackRepository.findByComplaintId(complaintId).isEmpty()) {
                throw new InvalidComplaintException(
                        "Feedback has already been submitted for this complaint."
                );
            }

            ComplaintFeedback feedback = new ComplaintFeedback(
                    complaintId,
                    complaint.getCitizenId(),
                    rating,
                    comments
            );

            feedback.setId(feedbackCounter++);

            feedbackRepository.save(feedback);

            complaint.setRating(rating);

            System.out.println("Feedback submitted successfully!");
            System.out.println("Complaint ID: " + complaintId);
            System.out.println("Rating: " + rating);
            System.out.println("Feedback: " + comments);
        }

        public void reopenComplaint(String complaintId, String reason) {

            Complaint complaint = getComplaintOrThrow(complaintId);

            if (!"RESOLVED".equals(complaint.getStatus())) {
                throw new InvalidComplaintException(
                        "Only resolved complaints can be reopened."
                );
            }

            if (complaint.isReopened()) {
                throw new InvalidComplaintException(
                        "Complaint can be reopened only once."
                );
            }

            if (reason == null || reason.isBlank()) {
                throw new InvalidComplaintException(
                        "Reopening reason cannot be empty."
                );
            }

            complaint.setStatus("REOPENED");
            complaint.setReopened(true);
            complaint.setResolvedAt(null);

            System.out.println("Complaint reopened successfully!");
            System.out.println("Complaint ID: " + complaintId);
            System.out.println("Reason: " + reason);
            System.out.println("New Status: REOPENED");
        }

        public void viewSLACompliance() {

            List<Complaint> complaints =
                    new ArrayList<>(repository.getAllComplaints());

            if (complaints.isEmpty()) {
                System.out.println("No complaints available.");
                return;
            }

            int compliant = 0;
            int breached = 0;
            int unavailable = 0;

            System.out.println("\n===== SLA COMPLIANCE REPORT =====");

            for (Complaint complaint : complaints) {

                LocalDateTime createdAt = complaint.getCreatedAt();
                LocalDateTime resolvedAt = complaint.getResolvedAt();

                if (createdAt == null) {
                    unavailable++;

                    System.out.println("\nComplaint ID: "
                            + complaint.getComplaintId());
                    System.out.println("SLA Status: DATA UNAVAILABLE");
                    continue;
                }

                long slaHours = 48;

                LocalDateTime deadline = createdAt.plusHours(slaHours);

                LocalDateTime comparisonTime =
                        resolvedAt != null ? resolvedAt : LocalDateTime.now();

                boolean isCompliant = !comparisonTime.isAfter(deadline);

                System.out.println("\nComplaint ID: "
                        + complaint.getComplaintId());

                System.out.println("Category: "
                        + complaint.getCategory());

                System.out.println("Status: "
                        + complaint.getStatus());

                System.out.println("SLA Deadline: " + deadline);

                if (isCompliant) {
                    compliant++;
                    System.out.println("SLA Status: COMPLIANT");
                } else {
                    breached++;
                    System.out.println("SLA Status: BREACHED");
                }
            }

            int evaluated = compliant + breached;

            double complianceRate = evaluated == 0
                    ? 0
                    : (compliant * 100.0) / evaluated;

            System.out.println("\n===== SLA SUMMARY =====");

            System.out.println("Total Complaints: " + complaints.size());
            System.out.println("SLA Compliant: " + compliant);
            System.out.println("SLA Breached: " + breached);
            System.out.println("Data Unavailable: " + unavailable);

            System.out.printf("SLA Compliance Rate: %.2f%%%n",
                    complianceRate);
        }

    }