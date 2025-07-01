package com.account;

public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account("Vanishitha");

        myAccount.deposit(1000);
        myAccount.withdraw(100);
        myAccount.withdraw(2000); // This should show an insufficient balance message
        myAccount.deposit(1500);

        System.out.println("Current Balance: $" + myAccount.getBalance());
        myAccount.printTransactionHistory();
    }
}

