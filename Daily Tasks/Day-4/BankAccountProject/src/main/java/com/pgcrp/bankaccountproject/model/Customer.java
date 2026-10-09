
package com.pgcrp.bankaccountproject.model;

public class Customer {

    private final String customerId;
    private final String name;
    private final String email;

    public Customer(String customerId, String name, String email) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID required");
        }

        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}