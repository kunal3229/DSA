package com.dsa.oops;

public class BankAccount {

    private String name;
    private double balance;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return 0;
        }
        balance -= amount;
        return amount;
    }
}

class BankMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000);
        System.out.println("Initial balance: " + account.getBalance());
        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());
        double withdrawnAmount = account.withdraw(200);
        System.out.println("Balance after withdrawal: " + account.getBalance());
        System.out.println("Withdrawn amount: " + withdrawnAmount);
        withdrawnAmount = account.withdraw(2000);
        System.out.println("Balance after withdrawal: " + account.getBalance());
        System.out.println("Withdrawn amount: " + withdrawnAmount);
    }
}
