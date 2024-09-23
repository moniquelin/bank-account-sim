package bank.abc.maven;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ActionProcessor action = new ActionProcessor();

        while (true) {
            // Display the main menu
            System.out.println("----------------------------------------------------------");
            System.out.println("Welcome to Bank ABC. What are you planning to do?\n");
            System.out.println("(1) Create a New Account");
            System.out.println("(2) View Account Details");
            System.out.println("(3) Deposit Money");
            System.out.println("(4) Withdraw Money");
            System.out.println("(5) Transfer Money");
            System.out.println("(6) Exit");

            // Get user choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 1:
                action.createAccount(scanner);
                break;

                case 2:
                action.viewAccountDetails(scanner);
                break;

                case 3:
                action.depositMoney(scanner);
                break;

                case 4:
                action.withdrawMoney(scanner);
                break;

                case 5:
                action.transferMoney(scanner);
                break;

                case 6:
                System.out.println("Exiting the application. Thank you for being a delighted customer.");
                scanner.close();
                return;

                default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
