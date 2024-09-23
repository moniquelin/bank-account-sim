package bank.abc.maven;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName) {
        // constructor for BankAccount
        System.out.println("Creating a new account...");
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0;
        System.out.println("Created account " + this.accountNumber + " for " + this.accountHolderName + " with balance 0.");
    }

    // deposit money
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    // getters and setters
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void getAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder Name: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
    }
}
