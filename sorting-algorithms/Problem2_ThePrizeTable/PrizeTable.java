import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C · SORTING ALGORITHMS
 * Problem 2: The Prize Table
 *
 * Task:
 * For the prize distribution, the teacher writes the marks on the board from
 * highest to lowest. In each round she finds the highest mark among the ones not
 * yet placed and swaps it into the next position.
 *
 * Write a method prizeTable(int[] marks) that sorts the marks in descending order
 * this way and returns how many swaps were actually made. Do not count a round
 * in which the highest mark is already in the right place.
 *
 * Examples:
 * Sample Input:
 * marks = [45, 90, 60, 75]
 * marks = [80, 70, 60]
 *
 * Expected Output:
 * [90, 75, 60, 45] swaps = 2
 * [80, 70, 60] swaps = 0
 */
public class PrizeTable {

    public static int prizeTable(int[] marks) {
        if (marks == null || marks.length <= 1) {
            return 0;
        }

        int n = marks.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if the maximum is not already in place
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swapCount++;
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> inputs = new ArrayList<>();

        try {
            if (System.in.available() > 0 && scanner.hasNextLine()) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) continue;
                    int start = line.indexOf('[');
                    int end = line.indexOf(']');
                    if (start != -1 && end != -1) {
                        String[] tokens = line.substring(start + 1, end).split("[,\\s]+");
                        List<Integer> nums = new ArrayList<>();
                        for (String t : tokens) {
                            if (!t.trim().isEmpty()) nums.add(Integer.parseInt(t.trim()));
                        }
                        inputs.add(nums.stream().mapToInt(i -> i).toArray());
                    }
                }
            }
        } catch (Exception ignored) {}

        if (!inputs.isEmpty()) {
            for (int[] arr : inputs) {
                int swaps = prizeTable(arr);
                System.out.println(Arrays.toString(arr) + " swaps = " + swaps);
            }
        } else {
            // Default sample demo
            int[] m1 = {45, 90, 60, 75};
            int s1 = prizeTable(m1);
            System.out.println(Arrays.toString(m1) + " swaps = " + s1);

            int[] m2 = {80, 70, 60};
            int s2 = prizeTable(m2);
            System.out.println(Arrays.toString(m2) + " swaps = " + s2);

            // Custom Test Case
            int[] m3 = {10, 50, 30, 40, 20};
            int s3 = prizeTable(m3);
            System.out.println("Custom input: " + Arrays.toString(m3) + " swaps = " + s3);
        }
        scanner.close();
    }
}
