package com.pgcrp.paymenthierarchy;

public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void pay();

    public void pay(double amount) {
        System.out.println("Processing payment of Rs. " + amount);
    }

    public void pay(double amount, String description) {
        System.out.println(description + ": Rs. " + amount);
    }

}
