package emailApp;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String emailId;
    private String altEmailId;
    private int defaultMailBoxCapacity=10;
    private int defaultPwdLength = 8;
    private String companyName = "larson";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment();
        generateEmailId();
        generateRandomPassword(defaultPwdLength);
    }

    private void setDepartment() {
        System.out.println("Department Codes  : \n 0 for sales \n 1 for development \n 2 for accounting \n 3 for none");
        System.out.print("Enter the Department Code : ");
        Scanner scanner = new Scanner(System.in);
        int code = scanner.nextInt();

        switch (code) {
            case 0:
                department = "sales";
                break;
            case 1:
                department = "development";
                break;
            case 2:
                department = "accounting";
                break;
            case 3:
                department = "";
                break;
            default:
                System.out.println("Invalid Department Code. Please Retry..");
                setDepartment();
        }

    }

    private void generateEmailId() {
        if (department.equals("")) {
            emailId = firstName.toLowerCase(Locale.ROOT) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + companyName.toLowerCase(Locale.ROOT) + ".com";
        } else {
            emailId = firstName.toLowerCase(Locale.ROOT) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + department.toLowerCase(Locale.ROOT) + "." + companyName.toLowerCase(Locale.ROOT) + ".com";
        }
    }

    private void generateRandomPassword(int length) {
        String pwdChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$!";
        Random random = new Random();
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomNum = random.nextInt(pwdChars.length() - 1);
            br.append(pwdChars.charAt(randomNum));
        }
        password = br.toString();
        System.out.println("Password generated : " + password);
    }

    public void setAltEmailId(String emailId) {
        altEmailId = emailId;
    }

    public String getEmailId() {
        generateEmailId();
        return emailId;
    }

    public String getPassword() {
        generateRandomPassword(defaultPwdLength);
        return password;
    }

    public void setDefaultMailBoxCapacity(int defaultMailBoxCapacity) {
        this.defaultMailBoxCapacity = defaultMailBoxCapacity;
    }

    public void setPassword(String updatedPassword) {
        if (updatedPassword.equals(password)) {
            throw new RuntimeException("New Password is same as the Old One. Kindly change the Password");
        } else {
            password = updatedPassword;
        }
    }

    public void displayUserDetails() {
        System.out.println("User Details : ");
        System.out.println("Name : " + firstName + " " + lastName);
        System.out.println("Email Id : " + emailId);
        System.out.println("Password : " + password);
        System.out.println("Alternate Email Id : " + altEmailId);
        System.out.println("Mail Capacity : " + defaultMailBoxCapacity);
    }
}
