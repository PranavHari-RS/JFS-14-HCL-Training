package com.pgcrp.publicgrievancecomplaintredressalportal;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.*;
import com.pgcrp.publicgrievancecomplaintredressalportal.repository.*;
import com.pgcrp.publicgrievancecomplaintredressalportal.sampledata.CsvDataLoader;

public class Day9RepositoryDemo {

    public static void main(String[] args) {

        ComplaintRepository complaintRepository =
                new ComplaintRepository();

        CitizenRepository citizenRepository =
                new CitizenRepository();

        FieldWorkerRepository workerRepository =
                new FieldWorkerRepository();

        System.out.println("===== DAY 9 REPOSITORY DEMO =====");

        CsvDataLoader.loadComplaints(complaintRepository);
        CsvDataLoader.loadCitizens(citizenRepository);
        CsvDataLoader.loadFieldWorkers(workerRepository);

        System.out.println("\n===== RECORD COUNTS =====");

        System.out.println(
                "Total Complaints: " +
                        complaintRepository.getComplaintCount()
        );

        System.out.println(
                "Total Citizens: " +
                        citizenRepository.count()
        );

        System.out.println(
                "Total Field Workers: " +
                        workerRepository.count()
        );

        System.out.println("\n===== FIND COMPLAINT =====");

        Complaint complaint = complaintRepository.findById("C101");

        System.out.println(complaint);

        System.out.println("\n===== FIND CITIZEN =====");

        System.out.println(
                citizenRepository.findById("U101").orElse(null)
        );

        System.out.println("\n===== FIND FIELD WORKER =====");

        System.out.println(
                workerRepository.findById("F101").orElse(null)
        );

        System.out.println("\n===== UPDATE COMPLAINT =====");

        if (complaint != null) {

            complaint.setStatus("RESOLVED");

            complaintRepository.updateComplaint(
                    complaint.getComplaintId(),
                    complaint
            );

            System.out.println(
                    complaintRepository.findById("C101")
            );
        }

        System.out.println("\n===== DELETE COMPLAINT =====");

        boolean deleted = complaintRepository.deleteComplaint("C104");

        System.out.println("Deleted: " + deleted);

        System.out.println(
                "Remaining Complaints: " +
                        complaintRepository.getComplaintCount()
        );

        System.out.println("\n===== ALL COMPLAINTS =====");

        complaintRepository.getAllComplaints()
                .forEach(System.out::println);
    }
}