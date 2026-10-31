import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Coding Assignment
 * Problem 4: Exam Score Band Counter
 *
 * Task:
 * A university stores the marks of all students in an exam as an array sorted
 * in ascending order; marks can repeat. Faculty members frequently ask how many
 * students scored within a band [low, high], inclusive of both ends.
 *
 * Implement a function countInBand(scores, low, high) that returns the number of
 * scores s such that low <= s <= high. The array is large and queried very often,
 * so your solution must not scan the scores one by one.
 *
 * Constraints:
 * - 1 <= length of scores <= 10^6
 * - scores is sorted in ascending order
 * - 0 <= low <= high <= 100
 *
 * Examples:
 * Sample 1:
 * scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 42, high = 58
 * Expected Output: 6
 *
 * Sample 2:
 * scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 90, high = 100
 * Expected Output: 0
 *
 * Complexity Requirements:
 * - Time Complexity: O(log N) using two binary searches (lower bound and upper bound).
 *   (Linear scan would be O(N), which is prohibited for 10^6 entries).
 * - Auxiliary Space Complexity: O(1).
 */
public class ExamScoreBandCounter {

    // Finds the first index where scores[i] >= target (lower bound)
    public static int lowerBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Finds the first index where scores[i] > target (upper bound)
    public static int upperBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }
        int firstIndex = lowerBound(scores, low);
        int afterLastIndex = upperBound(scores, high);
        return Math.max(0, afterLastIndex - firstIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int lowVal = -1;
        int highVal = -1;

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Parsing either array and query or comma/space separated
            if (line.contains("scores")) {
                int start = line.indexOf('[');
                int end = line.indexOf(']');
                if (start != -1 && end != -1) {
                    String[] tokens = line.substring(start + 1, end).split("[,\\s]+");
                    for (String token : tokens) {
                        if (!token.trim().isEmpty()) {
                            list.add(Integer.parseInt(token.trim()));
                        }
                    }
                }
                if (line.contains("low =") && line.contains("high =")) {
                    String[] parts = line.split("[,=]");
                    for (int i = 0; i < parts.length; i++) {
                        if (parts[i].trim().equalsIgnoreCase("low") && i + 1 < parts.length) {
                            lowVal = Integer.parseInt(parts[i + 1].trim());
                        }
                        if (parts[i].trim().equalsIgnoreCase("high") && i + 1 < parts.length) {
                            highVal = Integer.parseInt(parts[i + 1].trim());
                        }
                    }
                }
            } else {
                line = line.replace("[", "").replace("]", "").replace(",", " ");
                Scanner ls = new Scanner(line);
                while (ls.hasNextInt()) list.add(ls.nextInt());
                ls.close();
                if (scanner.hasNextInt()) lowVal = scanner.nextInt();
                if (scanner.hasNextInt()) highVal = scanner.nextInt();
            }
        }

        if (!list.isEmpty() && lowVal != -1 && highVal != -1) {
            int[] arr = list.stream().mapToInt(i -> i).toArray();
            System.out.println(countInBand(arr, lowVal, highVal));
        } else {
            // Default sample demo
            int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
            System.out.println(countInBand(scores, 42, 58));
        }
        scanner.close();
    }
}
