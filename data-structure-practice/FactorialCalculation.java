import java.math.BigInteger;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 7: Factorial Calculation
 *
 * Task:
 * Write a program that reads a non-negative integer and calculates its factorial.
 * The factorial of a non-negative integer 'n', denoted by 'n!', is the product
 * of all positive integers less than or equal to 'n'. The factorial of 0 is defined as 1.
 *
 * Example:
 * Input:
 * 5
 * 0
 * Output:
 * 120
 * 1
 */
public class FactorialCalculation {

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                System.out.println(factorial(n));
            }
        } else {
            System.out.println(factorial(5));
            System.out.println(factorial(0));
        }
        scanner.close();
    }
}
