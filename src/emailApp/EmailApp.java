package emailApp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        String fName = scanner.nextLine();
        System.out.print("Enter the Last Name : ");
        String lName = scanner.nextLine();

        Email email = new Email(fName, lName);
        email.setAltEmailId("dipu@yml.com");
        email.displayUserDetails();
    }
}
