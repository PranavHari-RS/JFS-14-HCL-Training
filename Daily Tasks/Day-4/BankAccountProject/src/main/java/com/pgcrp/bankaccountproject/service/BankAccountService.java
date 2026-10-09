
package com.pgcrp.bankaccountproject.service;

import com.pgcrp.bankaccountproject.model.BankAccount;

public class BankAccountService {

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public boolean withdraw(BankAccount account, double amount) {
        return account.withdraw(amount);
    }

    public void displayAccount(BankAccount account) {
        System.out.println(account);
    }
}