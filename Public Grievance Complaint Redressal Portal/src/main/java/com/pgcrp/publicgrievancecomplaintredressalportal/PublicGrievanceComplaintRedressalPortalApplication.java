package com.pgcrp.publicgrievancecomplaintredressalportal;

import com.pgcrp.publicgrievancecomplaintredressalportal.menu.ConsoleMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublicGrievanceComplaintRedressalPortalApplication {

    public static void main(String[] args) {

        ConsoleMenu menu = new ConsoleMenu();
        menu.displayMenu();
    }
}