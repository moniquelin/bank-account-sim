import java.util.ArrayList;
import java.util.Scanner;

public class ActionProcessor {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    int countAccounts; // number of Accounts in current session

    public void createAccount(Scanner scanner) {
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        BankAccount newAccount = new BankAccount(String.valueOf(countAccounts + 1), accountHolderName);
        this.countAccounts += 1;
        accounts.add(newAccount);
        System.out.println("Successfully created new account!" + "\n");
    }

    public void viewAccountDetails(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Here are the details of account with account number " + accountNumber);
        BankAccount searchedAccount = accounts.get(accountNumber);
        searchedAccount.getAccountDetails();
        System.out.println("\n");
    }

    public void depositMoney(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount searchedAccount = accounts.get(accountNumber);

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Successfully deposited money!");
        System.out.println("Previous balance: " + searchedAccount.getBalance());
        searchedAccount.deposit(amount);
        System.out.println("New balance: " + searchedAccount.getBalance() + "\n");
    }

    public void withdrawMoney(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount searchedAccount = accounts.get(accountNumber);

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > searchedAccount.getBalance()) {
            System.out.println("Failed to withdraw money!");
            System.out.println("Unable to withdraw since the amount is greater than current balance." + "\n");
        } else {
            System.out.println("Successfully withdrew money!");
            System.out.println("Previous balance: " + searchedAccount.getBalance());
            searchedAccount.withdraw(amount);
            System.out.println("New balance: " + searchedAccount.getBalance() + "\n");
        }
    }

    public void transferMoney(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount myAccount = accounts.get(accountNumber);

        System.out.print("Enter recipient's account number: ");
        int recipientNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount recipientAccount = accounts.get(recipientNumber);

        System.out.println("Transferring money to " + recipientAccount.getAccountHolderName());
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > myAccount.getBalance()) {
            System.out.println("Failed to transfer money!");
            System.out.println("Unable to transfer since the amount is greater than current balance." + "\n");
        } else {
            System.out.println("Successfully transferred " + amount + " to " + recipientAccount.getAccountHolderName());
            System.out.println("Previous balance: " + myAccount.getBalance());
            myAccount.withdraw(amount);
            recipientAccount.deposit(amount);
            System.out.println("New balance: " + myAccount.getBalance()+ "\n") ;
        }
    }

}
