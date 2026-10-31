import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C · SORTING ALGORITHMS
 * Problem 4: Is the Queue in Order?
 *
 * Task:
 * Students in the fee counter queue are supposed to stand in increasing order of
 * their token numbers. Equal token numbers next to each other are allowed.
 *
 * Write a method firstBreak(int[] tokens) that returns the position (index) of the
 * first student whose token number is smaller than the token of the student just
 * before them, or -1 if the whole queue is in order. An empty queue or a queue
 * of one student is always in order.
 *
 * Examples:
 * Sample Input:
 * tokens = [3, 5, 5, 8, 6, 9]
 * tokens = [1, 2, 2, 7]
 *
 * Expected Output:
 * 4  (6 comes after 8)
 * -1
 */
public class QueueInOrder {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
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
                int index = firstBreak(arr);
                if (index != -1) {
                    System.out.println(index + "    (" + arr[index] + " comes after " + arr[index - 1] + ")");
                } else {
                    System.out.println(index);
                }
            }
        } else {
            // Default sample demo
            int[] t1 = {3, 5, 5, 8, 6, 9};
            int b1 = firstBreak(t1);
            System.out.println(b1 + "    (" + t1[b1] + " comes after " + t1[b1 - 1] + ")");

            int[] t2 = {1, 2, 2, 7};
            int b2 = firstBreak(t2);
            System.out.println(b2);

            // Custom Test Case
            int[] t3 = {10, 20, 15, 30};
            int b3 = firstBreak(t3);
            System.out.println("Custom input break index: " + b3 + " (" + t3[b3] + " comes after " + t3[b3 - 1] + ")");
        }
        scanner.close();
    }
}
