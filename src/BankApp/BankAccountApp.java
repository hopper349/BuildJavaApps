package BankApp;

import Utilities.CsvReader;

import java.util.ArrayList;

public class BankAccountApp {
    public static void main(String[] args) {

        //Read a csv and create new accounts based on that data
        ArrayList<String[]> arr = new CsvReader().readCsv("src\\Utilities\\NewBankAccounts.csv");
        ArrayList<Account> accounts = new ArrayList<>();

        for (String[] data : arr) {
            if (data[2].equalsIgnoreCase("Savings")) {
                Savings savings = new Savings(data[0], data[1], Integer.valueOf(data[3]));
//                savings.showInfo();
                accounts.add(savings);
            } else {
                Checking checking = new Checking(data[0], data[1], Integer.valueOf(data[3]));
//                checking.showInfo();
                accounts.add(checking);
            }
        }

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("*******************************************");
        }
    }
}
