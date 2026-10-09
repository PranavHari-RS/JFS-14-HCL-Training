
package com.pgcrp.bankaccountproject;

import com.pgcrp.bankaccountproject.model.BankAccount;
import com.pgcrp.bankaccountproject.service.BankAccountService;

public class Day4DebugApp {

    public static void main(String[] args) {
        BankAccount account =
                new BankAccount("ACC101", "Pranav", 1000.0);

        BankAccountService service = new BankAccountService();

        service.displayAccount(account);

        service.deposit(account, 500.0);

        System.out.println("After deposit: " + account.getBalance());

        boolean result = service.withdraw(account, 1500.0);

        System.out.println("Withdrawal successful: " + result);
        System.out.println("Final balance: " + account.getBalance());
    }
}