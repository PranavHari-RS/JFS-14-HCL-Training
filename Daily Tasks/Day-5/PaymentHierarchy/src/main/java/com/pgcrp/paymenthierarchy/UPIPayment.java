package com.pgcrp.paymenthierarchy;

public class UPIPayment extends Payment implements Refundable {

    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid Rs. " + amount + " using UPI.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("UPI refund initiated: Rs. " + amount);
    }

}
