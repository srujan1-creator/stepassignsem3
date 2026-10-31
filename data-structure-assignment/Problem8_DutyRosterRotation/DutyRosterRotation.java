import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Coding Assignment
 * Problem 8: Duty Roster Rotation
 *
 * TASK:
 * A hostel rotates its cleaning duty roster every week by moving each name k places
 * to the right; names that go past the end wrap around to the front.
 *
 * Implement a function rotateRoster(names, k) that returns the roster after rotating
 * it to the right by k places. k may be larger than the number of names.
 *
 * CONSTRAINTS:
 * - 1 <= length of names <= 100
 * - 0 <= k <= 10^9
 *
 * EXAMPLES:
 * Sample 1:
 * names = [A, B, C, D, E], k = 2
 * Expected Output: [D, E, A, B, C]
 *
 * Sample 2:
 * names = [A, B, C, D, E], k = 7
 * Expected Output: [D, E, A, B, C] // 7 places is the same as 2
 *
 * COMPLEXITY REQUIREMENTS & ANALYSIS:
 * 1. Time Complexity: O(N) where N is the length of the names array.
 *    - Using modulo arithmetic `effectiveK = k % N`, we eliminate full cycles in O(1) math.
 *    - Placing each element at its target index `(i + effectiveK) % N` takes exactly N operations.
 * 2. Auxiliary Space Complexity: O(N) for the returned rotated array (or O(1) auxiliary
 *    space if rotating in-place via the three-reversal algorithm).
 * 3. Why rotating one place at a time, k times, is slow when k is large:
 *    - Shifting an array of size N by one place requires O(N) operations.
 *    - Repeating this shift k times results in O(k * N) time complexity.
 *    - Given the constraint k <= 10^9 and N <= 100, the naive approach would require
 *      up to 10^11 operations, which will cause Time Limit Exceeded (TLE) since a standard
 *      CPU executes approximately 10^8 operations per second.
 *    - The modulo optimization reduces k from 10^9 to at most N - 1 (< 100), ensuring
 *      instant execution.
 */
public class DutyRosterRotation {

    /**
     * Rotates names to the right by k places in O(N) time and O(N) space.
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length <= 1) {
            return names;
        }

        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK == 0) {
            return names.clone();
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    /**
     * Alternative in-place rotation using the 3-reversal algorithm in O(N) time and O(1) space.
     */
    public static void rotateRosterInPlace(String[] names, long k) {
        if (names == null || names.length <= 1) return;
        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK == 0) return;

        // 1. Reverse entire array
        reverse(names, 0, n - 1);
        // 2. Reverse first k elements
        reverse(names, 0, effectiveK - 1);
        // 3. Reverse remaining n - k elements
        reverse(names, effectiveK, n - 1);
    }

    private static void reverse(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        long k = -1;

        if (scanner.hasNextLine()) {
            String text = scanner.nextLine().trim();
            while (text.isEmpty() && scanner.hasNextLine()) {
                text = scanner.nextLine().trim();
            }

            if (text.contains("names") && text.contains("k")) {
                int start = text.indexOf('[');
                int end = text.indexOf(']');
                if (start != -1 && end != -1) {
                    String[] tokens = text.substring(start + 1, end).split("[,\\s]+");
                    for (String t : tokens) {
                        if (!t.trim().isEmpty()) list.add(t.trim());
                    }
                }
                int kIdx = text.indexOf("k");
                if (kIdx != -1) {
                    String rest = text.substring(kIdx).replaceAll("[^0-9]", " ").trim();
                    Scanner numScanner = new Scanner(rest);
                    if (numScanner.hasNextLong()) {
                        k = numScanner.nextLong();
                    }
                    numScanner.close();
                }
            } else if (text.contains("[") && text.contains("]")) {
                int start = text.indexOf('[');
                int end = text.indexOf(']');
                String[] tokens = text.substring(start + 1, end).split("[,\\s]+");
                for (String t : tokens) {
                    if (!t.trim().isEmpty()) list.add(t.trim());
                }
                String after = text.substring(end + 1).replaceAll("[^0-9]", " ").trim();
                Scanner numScanner = new Scanner(after);
                if (numScanner.hasNextLong()) {
                    k = numScanner.nextLong();
                }
                numScanner.close();
            } else if (!text.isEmpty()) {
                String[] tokens = text.split("\\s+");
                if (tokens.length >= 2) {
                    try {
                        int n = Integer.parseInt(tokens[0]);
                        k = Long.parseLong(tokens[1]);
                        for (int i = 2; i < 2 + n && i < tokens.length; i++) {
                            list.add(tokens[i]);
                        }
                    } catch (NumberFormatException ignored) {}
                }
            }
        }

        if (!list.isEmpty() && k >= 0) {
            String[] arr = list.toArray(new String[0]);
            String[] result = rotateRoster(arr, k);
            System.out.println(Arrays.toString(result));
        } else {
            // Default sample demo matching the assignment PDF
            String[] names1 = {"A", "B", "C", "D", "E"};
            System.out.println(Arrays.toString(rotateRoster(names1, 2)));

            String[] names2 = {"A", "B", "C", "D", "E"};
            System.out.println(Arrays.toString(rotateRoster(names2, 7)));
        }
        scanner.close();
    }
}
