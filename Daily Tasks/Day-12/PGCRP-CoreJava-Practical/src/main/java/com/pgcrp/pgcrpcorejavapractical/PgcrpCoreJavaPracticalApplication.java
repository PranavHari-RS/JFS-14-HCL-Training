package com.pgcrp.pgcrpcorejavapractical;

import com.pgcrp.pgcrpcorejavapractical.model.Complaint;
import com.pgcrp.pgcrpcorejavapractical.service.ComplaintService;
import com.pgcrp.pgcrpcorejavapractical.exception.ComplaintNotFoundException;

import java.util.Scanner;

public class PgcrpCoreJavaPracticalApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ComplaintService service = new ComplaintService();

        while (true) {

            System.out.println("\n======================================");
            System.out.println(" PUBLIC GRIEVANCE COMPLAINT PORTAL");
            System.out.println("======================================");
            System.out.println("1. File Complaint");
            System.out.println("2. Track Complaint");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    try {
                        System.out.print("Enter Citizen ID: ");
                        String citizenId = scanner.nextLine();

                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter Location: ");
                        String location = scanner.nextLine();

                        Complaint complaint = service.fileComplaint(
                                citizenId, category, description, location
                        );

                        System.out.println("\nComplaint Registered Successfully!");
                        System.out.println("Complaint ID: " + complaint.getComplaintId());
                        System.out.println("Status: " + complaint.getStatus());

                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Enter Complaint ID: ");
                        String complaintId = scanner.nextLine();

                        Complaint complaint = service.trackComplaint(complaintId);

                        System.out.println("\nComplaint Details:");
                        System.out.println(complaint);

                    } catch (ComplaintNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("Thank you for using PGCRP!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}