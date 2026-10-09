package com.pgcrp.publicgrievancecomplaintredressalportal.model;

public class Admin extends User {

    public Admin() {
        super();
        this.role = "ADMIN";
    }

    public Admin(String name, String email) {
        super(name, email, "ADMIN");
    }

    @Override
    public void displayResponsibilities() {
        System.out.println("Can manage users and oversee complaints.");
    }

}
