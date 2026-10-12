package com.pgcrp.librarywaitlist.model;

import java.time.LocalDate;

public class Book {

    private int bookId;
    private String title;
    private LocalDate dueDate;

    public Book(int bookId, String title, LocalDate dueDate) {
        this.bookId = bookId;
        this.title = title;
        this.dueDate = dueDate;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return bookId + " - " + title + " - Due Date: " + dueDate;
    }
}