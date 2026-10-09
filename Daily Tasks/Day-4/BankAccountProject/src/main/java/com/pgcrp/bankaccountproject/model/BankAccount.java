
package com.pgcrp.bankaccountproject.model;

import java.util.Objects;

public class BankAccount {

    private static int accountCounter = 0;

    private final String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount() {
        this("ACC" + (accountCounter + 1), "Unknown", 0.0);
    }

    public BankAccount(String accountNumber) {
        this(accountNumber, "Unknown", 0.0);
    }

    public BankAccount(String accountNumber, String holderName, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid account number");
        }
        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Invalid holder name");
        }
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException("Invalid balance");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        accountCounter++;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0
                || !Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("Invalid deposit");
        }

        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        // Intentional bug for the debugging exercise
        if (amount < balance) {
            balance -= amount;
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BankAccount)) return false;

        BankAccount other = (BankAccount) obj;
        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}