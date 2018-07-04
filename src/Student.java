import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private ArrayList<String> courses = new ArrayList<>();
    private int balance;
    private int coarseCost = 600;
    private static int id = 100;

    private boolean enrollLoop = true;

    /**
     * Creates a new student. Asks for first and last name and what year they're in.
     * Increases student number by 1.
     */

    public Student() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the student's first name:");
        this.firstName = in.nextLine();

        System.out.println("Enter the student's last name:");
        this.lastName = in.nextLine();

        System.out.println("Enter the student's class level \n1. Freshmen\n2. Sophmore\n3. Junior\n4. Senior");
        this.gradeYear = in.nextInt();

        createID();

        System.out.println(firstName + " " + lastName + " has been added to Year " + gradeYear + " with student ID: " + studentID);
    }


    /**
     * Generates a unique id for the added student.
     */

    private void createID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }


    /**
     * Lets the student enroll in courses.
     * Loops after every entry. "Q" To quit.
     */

    public void enroll() {

        while (enrollLoop) {
            System.out.println("Enter course to enroll (Press Q when finished): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            if (course.equalsIgnoreCase("Q") && course.equalsIgnoreCase("q")) {
                balance = balance + (coarseCost * courses.size());
                enrollLoop = false;

            } else {
                courses.add(course);
            }
        }


        System.out.println("Enrolled to classes: " + courses);
    }

    /**
     * Shows the remaining balance the student has to pay back.
     */

    public void viewBalance(){
        System.out.println("Your balance is now: $" + balance);
    }


    /**
     * Input the amount of money the student can/want/has to pay to reduce the debt.
     */

    public void payTuition(){
        System.out.println("Student current debt: " + balance);
        System.out.println("Please enter your payment amount: $");

        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        balance = balance - payment;

        System.out.println("\nThe payment has been processed.");
        viewBalance();
    }


    @Override
    public String toString(){
        return "\nName: " + firstName + " " + lastName +
                "\nCurrently in year: " + gradeYear + " with student ID: " +
                "\nCourses currently enrolled: " + courses +
                "\nCurrent debt: " + balance;
    }
}
