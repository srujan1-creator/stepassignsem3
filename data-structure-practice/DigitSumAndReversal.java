import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 5: Digit Sum and Number Reversal
 *
 * Task:
 * Write a program that reads a positive integer and performs two operations:
 * it calculates and prints the sum of its digits, and it prints the number
 * with its digits reversed.
 *
 * Example:
 * Input: 4721
 * Output:
 * Sum of digits: 14
 * Reverse: 1274
 */
public class DigitSumAndReversal {

    public static void computeSumAndReverse(long n) {
        long temp = Math.abs(n);
        long sum = 0;
        long reversed = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sum += digit;
            reversed = (reversed * 10) + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            computeSumAndReverse(n);
        } else {
            computeSumAndReverse(4721);
        }
        scanner.close();
    }
}
