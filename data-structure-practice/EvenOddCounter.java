import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 3: Even and Odd Numbers in a List
 *
 * Task:
 * Given a list of integers, write a program to count how many numbers in the list
 * are even and how many are odd. Print the counts for both categories.
 *
 * Example:
 * Input: [3, 8, 12, 5, 7, 10]
 * Output:
 * Even: 3
 * Odd: 3
 */
public class EvenOddCounter {

    public static void countEvenOdd(List<Integer> numbers) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Remove brackets if present: [3, 8, 12, 5, 7, 10]
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNextInt()) {
                list.add(lineScanner.nextInt());
            }
            lineScanner.close();
            countEvenOdd(list);
        } else {
            // Default sample demo
            countEvenOdd(List.of(3, 8, 12, 5, 7, 10));
        }
        scanner.close();
    }
}
