import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private String owner;
    private double balance;

    public static List<Account> accounts = new ArrayList<>();

    public Account(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        accounts.add(this);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
            Bank.trackTransaction("Deposit of " + amount + " to account: " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining balance: " + balance);
            Bank.trackTransaction("Withdrawal of " + amount + " from account: " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public void viewBalance() {
        System.out.println("Account Owner: " + owner);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    public static List<String> transactionHistory = new ArrayList<>();

    public static void displayBankInfo() {
        System.out.println("Welcome to the Bank Management System.");
        System.out.println("Total accounts: " + Account.accounts.size());
    }

    public static void trackTransaction(String description) {
        transactionHistory.add(description);
        System.out.println("Transaction recorded: " + description);
    }

    public static void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Bank.displayBankInfo();

        Account account1 = new Account("12345", "John Doe", 1000.0);
        Account account2 = new Account("67890", "Jane Smith", 500.0);

        account1.deposit(200);
        account1.withdraw(150);
        account1.viewBalance();

        account2.deposit(300);
        account2.withdraw(800);
        account2.viewBalance();

        Bank.displayTransactionHistory();
    }
}
