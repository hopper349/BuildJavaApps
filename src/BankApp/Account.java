package BankApp;

public abstract class Account implements IBaseRate {

    //List common properties for Savings and Checking Account
    private String name;
    private String ssn;
    private double balance;
    private static int index = 10000;

    protected String accountNumber;
    protected double rate;

    //Constructor to set Base properties and initialize the account
    public Account(String name, String ssn, double initDeposit) {
        this.name = name;
        this.ssn = ssn;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        setBaseRate();
    }

    private String setAccountNumber() {
        index++;
        String lastTwoSsn = ssn.substring(ssn.length() - 2);
        int uniqueID = index;
        int lastThree = (int) (Math.random() * Math.pow(10, 3));
        String acctNo = lastTwoSsn + uniqueID + lastThree;
        return acctNo;
    }

    public abstract void setBaseRate();


    public void showInfo() {
        System.out.println("NAME : " + name);
        System.out.println("SSN  : " + ssn);
        System.out.println("ACCOUNT NUM : " + accountNumber);
        System.out.println("BALANCE : " + balance);
        System.out.println("Rate : " + rate + "%");
    }

    //List common methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing : " + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawing : " + amount);
        } else {
            System.out.println("Not enough Balance.");
        }
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring : " + amount + " to " + toWhere);
        printBalance();
    }

    public void calCompoundInterest() {
        double accuredInterest = balance * (rate / 100.0);
        System.out.println("Interest Gained  : $" + accuredInterest);
        balance += accuredInterest;
        printBalance();
    }

    public void printBalance() {
        System.out.println("Balance : $" + balance);
    }

    @Override
    public String toString(){
        return "NAME : " + name+"\n"+
                "SSN  : " + ssn+"\n"+
                "ACCOUNT NUM : " + accountNumber+"\n"+
                "BALANCE : " + balance+"\n"+
                "Rate : " + rate + "%"+"\n";
    }
}
