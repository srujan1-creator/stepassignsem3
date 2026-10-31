import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C · SORTING ALGORITHMS
 * Problem 1: The Height Line-Up
 *
 * Task:
 * Students line up for the class photo and the photographer arranges them from
 * shortest to tallest by only swapping two students standing next to each other.
 * Write a method lineUp(int[] heights) that sorts the array this way and prints
 * the whole line after every sweep from left to right. If a sweep makes no swap
 * at all, the line is already in order: print that sweep and stop.
 *
 * Example:
 * Sample Input:
 * heights = [4, 2, 5, 1]
 * heights = [1, 3, 2, 4]
 *
 * Expected Output:
 * Pass 1: [2, 4, 1, 5]
 * Pass 2: [2, 1, 4, 5]
 * Pass 3: [1, 2, 4, 5]
 * Pass 1: [1, 2, 3, 4]
 * Pass 2: [1, 2, 3, 4]
 */
public class HeightLineUp {

    public static void lineUp(int[] heights) {
        if (heights == null || heights.length == 0) {
            return;
        }

        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            if (!swapped) {
                // If a sweep makes no swap at all, the line is already in order: stop.
                break;
            }
        }
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
                lineUp(arr);
            }
        } else {
            // Default sample inputs
            System.out.println("--- Sample 1 ---");
            lineUp(new int[]{4, 2, 5, 1});

            System.out.println("--- Sample 2 ---");
            lineUp(new int[]{1, 3, 2, 4});

            System.out.println("--- Custom Test Case (Reverse Sorted) ---");
            lineUp(new int[]{5, 4, 3, 2, 1});
        }
        scanner.close();
    }
}
