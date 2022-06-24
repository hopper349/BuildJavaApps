package BankApp;

public interface IBaseRate {

    //write a method that returns base rate

    default double getBaseRate(){
        return 2.5;
    }
}
