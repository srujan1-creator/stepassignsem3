import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Coding Assignment
 * Problem 8: Duty Roster Rotation
 *
 * Task:
 * A hostel rotates its cleaning duty roster every week by moving each name k places
 * to the right; names that go past the end wrap around to the front.
 *
 * Implement a function rotateRoster(names, k) that returns the roster after rotating
 * it to the right by k places. k may be larger than the number of names.
 *
 * Constraints:
 * - 1 <= length of names <= 100
 * - 0 <= k <= 10^9
 *
 * Examples:
 * Sample 1:
 * names = [A, B, C, D, E], k = 2
 * Expected Output: [D, E, A, B, C]
 *
 * Sample 2:
 * names = [A, B, C, D, E], k = 7
 * Expected Output: [D, E, A, B, C] // 7 places is the same as 2
 *
 * Complexity Requirements:
 * - Time Complexity: O(N) using modulo rotation.
 *   (Rotating one place at a time k times is O(k * N), which TLEs when k = 10^9).
 * - Space Complexity: O(N) or O(1) in-place reversal.
 */
public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length <= 1) {
            return names;
        }

        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK == 0) {
            return names;
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        long k = -1;

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.contains("names") && line.contains("k =")) {
                int start = line.indexOf('[');
                int end = line.indexOf(']');
                if (start != -1 && end != -1) {
                    String[] tokens = line.substring(start + 1, end).split("[,\\s]+");
                    for (String t : tokens) {
                        if (!t.trim().isEmpty()) list.add(t.trim());
                    }
                }
                String kPart = line.substring(line.indexOf("k =") + 3).trim();
                k = Long.parseLong(kPart.split("[,\\s]+")[0]);
            }
        }

        if (!list.isEmpty() && k != -1) {
            String[] arr = list.toArray(new String[0]);
            System.out.println(Arrays.toString(rotateRoster(arr, k)));
        } else {
            // Default sample demo
            String[] names1 = {"A", "B", "C", "D", "E"};
            System.out.println(Arrays.toString(rotateRoster(names1, 2)));
            String[] names2 = {"A", "B", "C", "D", "E"};
            System.out.println(Arrays.toString(rotateRoster(names2, 7)));
        }
        scanner.close();
    }
}
