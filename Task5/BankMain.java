package Elevate_Labs_Internship.Task5;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {

	static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== BANK SYSTEM ======");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: login(); break;
                case 3: System.out.println("Thank You!"); break;
                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 3);
    }


    // Here we Create New Account.
    static void createAccount() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("Set PIN: ");
        int pin = sc.nextInt();

        Account acc = new Account(name, bal, pin);
        accounts.add(acc);

        System.out.println("✅ Account Created!");
        System.out.println("Your Account Number = " + acc.accNo);
    }

    // Here we Check Acc No. and PIN for Login and redirect to Operational Menu
    static void login() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        for (Account acc : accounts) {
            if (acc.accNo == accNo && acc.pin == pin) {
                System.out.println(" Login Successful!");
                accountMenu(acc);
                return;
            }
        }
        System.out.println(" Invalid Account/PIN!");
    }


    // Here is Operational Menu after Login Successful.
    static void accountMenu(Account acc) {
        int choice;

        do {
            System.out.println("\n==== ACCOUNT MENU ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Logout");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: deposit(acc); break;
                case 2: withdraw(acc); break;
                case 3: checkBalance(acc); break;
                case 4: acc.showTransactions(); break;
                case 5: System.out.println("Logged Out!"); break;
                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }


    // Here are Operations for Account Holders.
    static void deposit(Account acc) {
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();
        acc.deposit(amount);
        System.out.println("Amount Deposited!");
    }

    static void withdraw(Account acc) {
        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();
        acc.withdraw(amount);
        System.out.println("Amount Withdrawed!");
    }

    static void checkBalance(Account acc) {
        System.out.println("Current Balance: ₹" + acc.balance);
    }
}
