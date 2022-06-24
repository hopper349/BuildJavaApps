package StudentDb;

import java.util.Scanner;

public class StudentDbApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of students to enroll.");
        int noOfStudents = sc.nextInt();
        sc.nextLine();
        StudentDataBase [] st = new StudentDataBase[noOfStudents];

        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("Enter the student's name");
            String name = sc.nextLine();
            System.out.println("Enter the student's year");
            int year = sc.nextInt();
            sc.nextLine();

            st[i] = new StudentDataBase(name,year);
            st[i].payTuitionFee();
            System.out.println(st[i]);
        }
    }
}
