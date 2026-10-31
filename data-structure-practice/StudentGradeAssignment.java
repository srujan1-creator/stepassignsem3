import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 8: Student Grade Assignment
 *
 * Task:
 * Write a program that reads a student's marks (out of 100) and prints their
 * corresponding grade based on the following criteria:
 * - A: 90 or above
 * - B: 75 to 89
 * - C: 60 to 74
 * - D: 40 to 59
 * - F: Below 40
 *
 * Example:
 * Input:
 * 72
 * 95
 * 35
 * Output:
 * Grade C
 * Grade A
 * Grade F
 */
public class StudentGradeAssignment {

    public static String getGrade(double marks) {
        if (marks >= 90.0) {
            return "Grade A";
        } else if (marks >= 75.0) {
            return "Grade B";
        } else if (marks >= 60.0) {
            return "Grade C";
        } else if (marks >= 40.0) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            while (scanner.hasNextDouble()) {
                double marks = scanner.nextDouble();
                System.out.println(getGrade(marks));
            }
        } else {
            System.out.println(getGrade(72));
            System.out.println(getGrade(95));
            System.out.println(getGrade(35));
        }
        scanner.close();
    }
}
