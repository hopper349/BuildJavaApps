package StudentDb;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentDataBase {

    private String userName;
    private int year;
    private int grade;
    private static int initialId = 1000;
    private int uniqueId;
    private int tuitionFee = 0;
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> coursesEnrolled = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public StudentDataBase(String userName, int year) {
        this.userName = userName;
        this.year = year;
        setGradeLevel();
        generateUniqueId();
        enrollInCourses();
    }

    private void setGradeLevel() {
        System.out.println("Choose the Grade Level from below options : ");
        System.out.println("Enter 1 for 'Freshman Year' \nEnter 2 for 'Sophomore Year' \nEnter 3 for 'Junior Year' \nEnter 4 for 'Senior Year'");
        grade = scanner.nextInt();
        scanner.nextLine();
    }

    private void generateUniqueId() {
        initialId++;
        uniqueId = initialId + 10000 * grade;
    }

    private void enrollInCourses() {
        courses.add("History 101");
        courses.add("Mathematics 101");
        courses.add("English 101");
        courses.add("Chemistry 101");
        courses.add("Computer Science 101");
        System.out.println("Enter 'yes' or 'no' for the below questions");
        for (String course : courses) {
            System.out.println("Do you want to enroll in " + course + " ?");
            String flag = scanner.nextLine();
            if (flag.trim().equalsIgnoreCase("yes")) {
                coursesEnrolled.add(course);
                tuitionFee += 600;
            }
        }
    }

    public void viewBalance() {
        System.out.println("Balance Amount : " + tuitionFee);
    }

    public void payTuitionFee() {
        System.out.println("Enter the amount to Pay");
        int amountPaid = scanner.nextInt();
        scanner.nextLine();
        tuitionFee = tuitionFee - amountPaid;
    }

    @Override
    public String toString() {
        String courses = "";
        for (String course : coursesEnrolled) {
            courses += course + "\n";
        }

        return "Name : " + userName + "\n" +
                "ID : " + uniqueId + "\n" +
                "Balance : " + tuitionFee + "\n" +
                "Courses Enrolled : \n" + courses;

    }

}
