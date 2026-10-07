package com.pgcrp.publicgrievancecomplaintredressalportal.menu;

import java.util.Scanner;

public class ConsoleMenu {

    public void displayMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

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

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("FR1: File Complaint");
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
                    System.out.println("FR6: Track Complaint");
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
        }
    }
}