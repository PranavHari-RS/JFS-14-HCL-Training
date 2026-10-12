package com.pgcrp.librarywaitlist.service;

import com.pgcrp.librarywaitlist.model.Book;
import com.pgcrp.librarywaitlist.model.BookRequest;

import java.time.LocalDate;
import java.util.*;

public class LibraryService {

    private final ArrayList<Book> catalogue = new ArrayList<>();

    private final LinkedHashSet<Integer> bookIds = new LinkedHashSet<>();

    private final ArrayDeque<String> waitlist = new ArrayDeque<>();

    private final PriorityQueue<BookRequest> priorityQueue =
            new PriorityQueue<>();

    private long requestCounter = 0;

    public void addBook(int id, String title, LocalDate dueDate) {

        if (!bookIds.add(id)) {
            System.out.println("Duplicate Book ID! Book not added.");
            return;
        }

        catalogue.add(new Book(id, title, dueDate));

        System.out.println("Book added successfully!");
    }

    public void displayBooks() {

        if (catalogue.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== BOOK CATALOGUE =====");

        for (Book book : catalogue) {
            System.out.println(book);
        }
    }

    public void joinWaitlist(String name) {

        waitlist.offerLast(name);

        System.out.println(name + " joined the waitlist.");
    }

    public void processWaitlist() {

        if (waitlist.isEmpty()) {
            System.out.println("Waitlist is empty.");
            return;
        }

        System.out.println("Serving: " + waitlist.pollFirst());
    }

    public void addPriorityRequest(String name,
                                   String role,
                                   String bookTitle) {

        if (!role.equalsIgnoreCase("Faculty")
                && !role.equalsIgnoreCase("Student")) {
            System.out.println("Invalid role. Use Faculty or Student.");
            return;
        }

        priorityQueue.offer(
                new BookRequest(name, role, bookTitle, ++requestCounter)
        );

        System.out.println("Priority request added successfully!");
    }

    public void processPriorityRequest() {

        if (priorityQueue.isEmpty()) {
            System.out.println("No priority requests.");
            return;
        }

        System.out.println("Processing: " + priorityQueue.poll());
    }

    public void removeOverdueBooks() {

        Iterator<Book> iterator = catalogue.iterator();

        int removed = 0;

        while (iterator.hasNext()) {

            Book book = iterator.next();

            if (book.getDueDate().isBefore(LocalDate.now())) {

                iterator.remove();

                bookIds.remove(book.getBookId());

                System.out.println("Removed overdue: " + book.getTitle());

                removed++;
            }
        }

        if (removed == 0) {
            System.out.println("No overdue books found.");
        }
    }
}