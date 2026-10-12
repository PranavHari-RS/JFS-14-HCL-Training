package com.pgcrp.librarywaitlist.model;

public class BookRequest implements Comparable<BookRequest> {

    private String name;
    private String role;
    private String bookTitle;
    private long requestNumber;

    public BookRequest(String name, String role,
                       String bookTitle, long requestNumber) {
        this.name = name;
        this.role = role;
        this.bookTitle = bookTitle;
        this.requestNumber = requestNumber;
    }

    public int getPriority() {
        return role.equalsIgnoreCase("Faculty") ? 1 : 2;
    }

    @Override
    public int compareTo(BookRequest other) {

        int priorityComparison =
                Integer.compare(this.getPriority(), other.getPriority());

        if (priorityComparison != 0) {
            return priorityComparison;
        }

        return Long.compare(this.requestNumber, other.requestNumber);
    }

    @Override
    public String toString() {
        return name + " (" + role + ") requested " + bookTitle;
    }
}