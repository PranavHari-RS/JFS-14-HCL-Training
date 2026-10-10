package com.pgcrp.paymenthierarchy;

public class CardPayment extends Payment implements Refundable {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid Rs. " + amount + " using Card.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Card refund initiated: Rs. " + amount);
    }

}
