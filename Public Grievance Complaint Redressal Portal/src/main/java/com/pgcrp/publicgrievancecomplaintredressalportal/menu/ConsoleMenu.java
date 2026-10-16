package com.pgcrp.publicgrievancecomplaintredressalportal.menu;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.exception.ComplaintNotFoundException;
import com.pgcrp.publicgrievancecomplaintredressalportal.service.ComplaintService;
import com.pgcrp.publicgrievancecomplaintredressalportal.strategy.CategoryBasedRouting;

import java.util.Scanner;

public class ConsoleMenu {

    private final ComplaintService complaintService = new ComplaintService();

    public void displayMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("\n===== PUBLIC GRIEVANCE COMPLAINT REDRESSAL PORTAL =====");
                System.out.println("1. File Complaint");
                System.out.println("2. Route Complaint");
                System.out.println("3. Assign Field Worker");
                System.out.println("4. Update Complaint Status");
                System.out.println("5. Escalate Complaint");
                System.out.println("6. Track Complaint");
                System.out.println("7. Rate/Reopen Complaint");
                System.out.println("8. View SLA Compliance");
                System.out.println("9. Exit");
                System.out.println("10. View Sorted Complaint Report");
                System.out.println("11. View Priority Sorted Report");
                System.out.println("12. View Status Sorted Report");

                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:

                        System.out.println("FR1: File Complaint");

                        System.out.print("Enter Citizen ID: ");
                        String citizenId = scanner.nextLine();

                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter Location: ");
                        String location = scanner.nextLine();

                        complaintService.fileComplaint(
                                citizenId, category, description, location);
                        break;

                    case 2:

                        System.out.println("FR2: Route Complaint");

                        complaintService.routeComplaint();
                        break;

                    case 3:

                        System.out.println("FR3: Assign Field Worker");

                        System.out.print("Enter Complaint ID: ");
                        String complaintId = scanner.nextLine();

                        complaintService.assignFieldWorker(
                                complaintId,
                                new CategoryBasedRouting()
                        );
                        break;

                    case 4:

                        System.out.println("FR4: Update Complaint Status");

                        System.out.print("Enter Complaint ID: ");
                        String updateId = scanner.nextLine();

                        System.out.print("Enter New Status: ");
                        String newStatus = scanner.nextLine();

                        complaintService.updateComplaintStatus(updateId, newStatus);

                        break;

                    case 5:

                        System.out.println("FR5: Escalate Complaint");

                        System.out.print("Enter Complaint ID: ");
                        String escalateId = scanner.nextLine();

                        complaintService.escalateComplaint(escalateId);

                        break;

                    case 6:

                        System.out.println("FR6: Track Complaint");

                        System.out.print("Enter Complaint ID: ");
                        String trackId = scanner.nextLine();

                        complaintService.trackComplaint(trackId);

                        break;

                    case 7:

                        System.out.println("\n===== FR7: RATE / REOPEN COMPLAINT =====");

                        System.out.print("Enter Complaint ID: ");
                        String feedbackComplaintId = scanner.nextLine();

                        System.out.println("1. Rate Complaint");
                        System.out.println("2. Reopen Complaint");

                        System.out.print("Enter choice: ");
                        int feedbackChoice = Integer.parseInt(scanner.nextLine());

                        switch (feedbackChoice) {

                            case 1:

                                System.out.print("Enter Rating (1-5): ");
                                int rating = Integer.parseInt(scanner.nextLine());

                                System.out.print("Enter Feedback Comments: ");
                                String comments = scanner.nextLine();

                                complaintService.rateComplaint(
                                        feedbackComplaintId,
                                        rating,
                                        comments
                                );

                                break;

                            case 2:

                                System.out.print("Enter Reopening Reason: ");
                                String reason = scanner.nextLine();

                                complaintService.reopenComplaint(
                                        feedbackComplaintId,
                                        reason
                                );

                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }

                        break;

                    case 8:

                        System.out.println("FR8: View SLA Compliance");

                        complaintService.viewSLACompliance();

                        break;

                    case 9:

                        System.out.println("Exiting...");
                        return;

                    case 10:
                        complaintService.displaySortedReport();
                        break;

                    case 11:
                        complaintService.displayPriorityReport();
                        break;

                    case 12:
                        complaintService.displayStatusReport();
                        break;

                    default:

                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                System.out.println("Returning to main menu...");
            }
        }
    }
}