package com.pgcrp.publicgrievancecomplaintredressalportal.model;

import com.pgcrp.publicgrievancecomplaintredressalportal.common.BaseEntity;

public abstract class User extends BaseEntity {

    protected String name;
    protected String email;
    protected String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public abstract void displayResponsibilities();
}