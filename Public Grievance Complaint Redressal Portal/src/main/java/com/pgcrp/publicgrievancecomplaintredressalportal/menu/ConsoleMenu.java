
package com.pgcrp.publicgrievancecomplaintredressalportal.menu;

import com.pgcrp.publicgrievancecomplaintredressalportal.model.Complaint;
import com.pgcrp.publicgrievancecomplaintredressalportal.exception.ComplaintNotFoundException;
import java.util.Set;
import java.util.HashSet;

import java.util.Scanner;

public class ConsoleMenu {

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

                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("FR1: File Complaint");

                        System.out.print("Enter complaint description: ");
                        String description = scanner.nextLine();

                        Complaint.validateDescription(description);

                        System.out.println("Complaint description is valid.");
                        break;

                    case 2:
                        System.out.println("FR2: Route Complaint");
                        break;

                    case 3:
                        System.out.println("FR3: Assign Field Worker");
                        break;

                    case 4:
                        System.out.println("FR4: Update Complaint Status");
                        break;

                    case 5:
                        System.out.println("FR5: Escalate Complaint");
                        break;

                    case 6:
                        /*System.out.println("FR6: Track Complaint");
                        break;*/
                        System.out.println("FR6: Track Complaint");

                        Set<String> complaintIds = new HashSet<>();
                        complaintIds.add("C001");
                        complaintIds.add("C002");

                        System.out.print("Enter complaint ID: ");
                        String id = scanner.nextLine();

                        validateComplaintExists(id, complaintIds);

                        System.out.println("Complaint found: " + id);
                        break;

                    case 7:
                        System.out.println("FR7: Rate/Reopen Complaint");
                        break;

                    case 8:
                        System.out.println("FR8: View SLA Compliance");
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Returning to main menu...");
            }
        }
    }
    private void validateComplaintExists(String complaintId, Set<String> complaintIds) {
        if (!complaintIds.contains(complaintId)) {
            throw new ComplaintNotFoundException(
                    "Complaint not found for ID: " + complaintId
            );
        }
    }
}
