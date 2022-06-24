package BankApp;

public class Checking extends Account {

    //List properties specific to a Checking account
    private int debitCardNum;
    private int debitCardPin;

    //Constructor to initialize account properties
    public Checking(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        System.out.println("NEW CHECKING ACCOUNT");
        accountNumber = 2 + accountNumber;
        setDebitCard();
    }

    //List any method specific to Checking account
    private void setDebitCard() {
        debitCardNum = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void setBaseRate() {
        rate = getBaseRate() * 0.15;
    }

    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE : CHECKING");
        super.showInfo();
        System.out.println("Account Features : ");
        System.out.println("DebitCardNum : " + debitCardNum + "\nDebitCardPin : " + debitCardPin);
    }

    @Override
    public String toString() {
        return "ACCOUNT TYPE : CHECKING" + "\n" +
                super.toString() +
                "Account Features : " + "\n" +
                "DebitCardNum : " + debitCardNum + "\n" +
                "DebitCardPin : " + debitCardPin;
    }
}
