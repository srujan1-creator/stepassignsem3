import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C · SORTING ALGORITHMS
 * Problem 5: The Dice Throw Tally
 *
 * Task:
 * In a maths activity, a student throws a die several times and writes down each
 * result (a number from 1 to 6). Write a method diceSort(int[] rolls) that first
 * counts how many times each number from 1 to 6 appeared, prints these counts,
 * and then uses the counts to build and return the results in increasing order.
 * Do not compare two throws with each other.
 *
 * Example:
 * Sample Input: rolls = [4, 1, 6, 4, 2, 1, 4]
 * Expected Output:
 * Counts: 1:2 2:1 3:0 4:3 5:0 6:1
 * Sorted: [1, 1, 2, 4, 4, 4, 6]
 */
public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        if (rolls == null || rolls.length == 0) {
            return new int[0];
        }

        // Tally array for values 1 to 6 (using size 7 so index directly represents face value)
        int[] counts = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                counts[roll]++;
            }
        }

        // Print counts in format: Counts: 1:2 2:1 3:0 4:3 5:0 6:1
        StringBuilder countsSb = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            countsSb.append(v).append(":").append(counts[v]);
            if (v < 6) {
                countsSb.append(" ");
            }
        }
        System.out.println(countsSb.toString());

        // Reconstruct sorted array without comparing elements
        int[] sorted = new int[rolls.length];
        int writeIndex = 0;
        for (int v = 1; v <= 6; v++) {
            for (int count = 0; count < counts[v]; count++) {
                sorted[writeIndex++] = v;
            }
        }

        return sorted;
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
                int[] sorted = diceSort(arr);
                System.out.println("Sorted: " + Arrays.toString(sorted));
            }
        } else {
            // Default sample demo
            System.out.println("--- Sample Input ---");
            int[] sorted1 = diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
            System.out.println("Sorted: " + Arrays.toString(sorted1));

            System.out.println("--- Custom Test Case ---");
            int[] sorted2 = diceSort(new int[]{6, 6, 5, 1, 2, 3, 3});
            System.out.println("Sorted: " + Arrays.toString(sorted2));
        }
        scanner.close();
    }
}
