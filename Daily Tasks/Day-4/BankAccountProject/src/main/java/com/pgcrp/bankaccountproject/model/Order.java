
package com.pgcrp.bankaccountproject.model;

public class Order {

    private final String orderId;
    private final double amount;
    private String status;

    public Order(String orderId, double amount, String status) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID required");
        }
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Invalid order amount");
        }

        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}