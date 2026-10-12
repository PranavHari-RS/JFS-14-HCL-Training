package com.pgcrp.librarywaitlist;

import com.pgcrp.librarywaitlist.menu.ConsoleMenu;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryWaitlistApplication {

    public static void main(String[] args) {

        ConsoleMenu menu = new ConsoleMenu();

        menu.displayMenu();
    }
}