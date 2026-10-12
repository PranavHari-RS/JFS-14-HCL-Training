package com.pgcrp.librarywaitlist.menu;

import com.pgcrp.librarywaitlist.service.LibraryService;
import com.pgcrp.librarywaitlist.service.PerformanceTest;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleMenu {

    private final LibraryService libraryService = new LibraryService();

    public void displayMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("\n===== LIBRARY WAITLIST SYSTEM =====");
                System.out.println("1. Add Book");
                System.out.println("2. Display Catalogue");
                System.out.println("3. Join Waitlist");
                System.out.println("4. Process Waitlist");
                System.out.println("5. Add Priority Request");
                System.out.println("6. Process Priority Request");
                System.out.println("7. Remove Overdue Books");
                System.out.println("8. Compare ArrayList vs LinkedList");
                System.out.println("9. Exit");

                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Enter Book ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Due Date (YYYY-MM-DD): ");
                        LocalDate dueDate =
                                LocalDate.parse(scanner.nextLine());

                        libraryService.addBook(id, title, dueDate);
                        break;

                    case 2:

                        libraryService.displayBooks();
                        break;

                    case 3:

                        System.out.print("Enter Student Name: ");
                        String student = scanner.nextLine();

                        libraryService.joinWaitlist(student);
                        break;

                    case 4:

                        libraryService.processWaitlist();
                        break;

                    case 5:

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Role (Faculty/Student): ");
                        String role = scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        String bookTitle = scanner.nextLine();

                        libraryService.addPriorityRequest(
                                name, role, bookTitle);
                        break;

                    case 6:

                        libraryService.processPriorityRequest();
                        break;

                    case 7:

                        libraryService.removeOverdueBooks();
                        break;

                    case 8:

                        PerformanceTest.comparePerformance();
                        break;

                    case 9:

                        System.out.println("Exiting Library Waitlist System...");
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
}