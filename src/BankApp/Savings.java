package BankApp;

public class Savings extends Account {

    //List properties specific to a Savings account

    private int safetyDepositBoxId;
    private int getSafetyDepositBoxKey;

    //Constructor to initialize account properties

    public Savings(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        accountNumber = 1 + accountNumber;
        setSafetyDepositBox();
    }

    //List any method specific to Savings account

    private void setSafetyDepositBox() {
        safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
        getSafetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void setBaseRate() {
        rate = getBaseRate() - 0.25;
    }

    @Override
    public void showInfo() {
        System.out.println("ACCOUNT TYPE : SAVINGS");
        super.showInfo();
        System.out.println("Account Features : ");
        System.out.println("SafetyDepositBoxId : " + safetyDepositBoxId + "\nSafetyDepositBoxKey : " + getSafetyDepositBoxKey);
    }


    @Override
    public String toString() {
        return "ACCOUNT TYPE : CHECKING" + "\n" +
                super.toString() + "\n" +
                "Account Features : " + "\n" +
                "SafetyDepositBoxId : " + safetyDepositBoxId + "\n" +
                "SafetyDepositBoxKey : " + getSafetyDepositBoxKey;
    }

}
