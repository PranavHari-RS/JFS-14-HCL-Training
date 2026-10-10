package com.pgcrp.paymenthierarchy;

public class Main {

    public static void main(String[] args) {

        Payment card = new CardPayment(1500);
        Payment upi = new UPIPayment(500);
        Payment cash = new CashPayment(200);

        card.pay();
        upi.pay();
        cash.pay();

        card.pay(2500);
        card.pay(3000, "Online purchase");

        Refundable cardRefund = (Refundable) card;
        cardRefund.refund(500);

        Refundable upiRefund = (Refundable) upi;
        upiRefund.refund(200);
    }

}
