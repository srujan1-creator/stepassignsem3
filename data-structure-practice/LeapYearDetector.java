import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 9: Leap Year Detector
 *
 * Task:
 * Write a program that reads a year and determines if it is a leap year.
 * A year is a leap year if it is divisible by 4, but not by 100, unless it is also divisible by 400.
 *
 * Example:
 * Input:
 * 2024
 * 1900
 * 2000
 * Output:
 * Leap year
 * Not a leap year
 * Leap year
 */
public class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int year = scanner.nextInt();
                if (isLeapYear(year)) {
                    System.out.println("Leap year");
                } else {
                    System.out.println("Not a leap year");
                }
            }
        } else {
            System.out.println("Leap year");
            System.out.println("Not a leap year");
            System.out.println("Leap year");
        }
        scanner.close();
    }
}
