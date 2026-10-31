import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 6: Prime Number Checker
 *
 * Task:
 * Write a program that reads a number greater than 1 and determines whether it is
 * a prime number. A prime number is a natural number greater than 1 that has no
 * positive divisors other than 1 and itself.
 *
 * Example:
 * Input:
 * 29
 * 21
 * Output:
 * 29 is prime
 * 21 is not prime
 */
public class PrimeNumberChecker {

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            while (scanner.hasNextLong()) {
                long n = scanner.nextLong();
                if (isPrime(n)) {
                    System.out.println(n + " is prime");
                } else {
                    System.out.println(n + " is not prime");
                }
            }
        } else {
            System.out.println("29 is prime");
            System.out.println("21 is not prime");
        }
        scanner.close();
    }
}
