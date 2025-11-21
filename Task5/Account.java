package Elevate_Labs_Internship.Task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Account {

	private static int nextAccNo = 1001;

    int accNo;
    String name;
    int pin;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();

    public Account(String name, double balance, int pin) {
        this.accNo = nextAccNo++;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        transactions.add("Account Created with Balance: ₹" + balance);

        saveAccountToFile();
    }

    // Here we Save the accounds details.
    public void saveAccountToFile() {
        try {
            FileWriter fw = new FileWriter("D://A.bankProgram/accounts.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(accNo + "," + name + "," + balance + "," + pin + "\n");
            
            bw.close();
        } catch (Exception e) {
            System.out.println("Error saving account!"+e.getMessage().toString());
        }
    }

    // Here we Save the Transactions.
    public void saveTransaction(String text) {
        try {
            FileWriter fw = new FileWriter("D://A.bankProgram/transactions_" + accNo + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text + "\n");
            
            bw.close();
        } catch (Exception e) {
            System.out.println("Error writing transaction!"+e.getMessage().toString());
        }
    }

    // Followings are Operation of Banks like - deposit,withdraw,seeTransaction etc.
    public void deposit(double amount) {
        balance += amount;
        String msg = "Deposited ₹" + amount;
        transactions.add(msg);
        saveTransaction(msg);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(" Insufficient Balance!");
            return;
        }
        balance -= amount;
        String msg = "Withdraw ₹" + amount;
        transactions.add(msg);
        saveTransaction(msg);
    }

    public void showTransactions() {
        System.out.println("\n===== Transaction History =====");
        for (String t : transactions)
            System.out.println(t);

        // also load from file
        try {
            File f = new File("D://A.bankProgram/transactions_" + accNo + ".txt");
            if (f.exists()) {
            	FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
                br.close();
            }
        } catch (Exception e) {
            System.out.println("Error reading transactions!");
        }
    }
}
