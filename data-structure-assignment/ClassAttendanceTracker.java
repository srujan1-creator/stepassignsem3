import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Coding Assignment
 * Problem 6: Class Attendance Tracker
 *
 * Task:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent),
 * one value per day. The teacher wants to know how many days the student was present and
 * the longest run of days the student attended without a break.
 *
 * Implement a function attendanceSummary(days) that returns the number of present days
 * and the length of the longest unbroken run of present days.
 *
 * Constraints:
 * - 1 <= length of days <= 100
 * - Each value is 0 or 1
 *
 * Examples:
 * Sample 1:
 * days = [1, 1, 0, 1, 1, 1, 0, 1]
 * Expected Output: Present: 6, Longest streak: 3
 *
 * Sample 2:
 * days = [0, 0, 0]
 * Expected Output: Present: 0, Longest streak: 0
 *
 * Complexity Requirements:
 * - Time Complexity: O(N) single-pass.
 * - Auxiliary Space Complexity: O(1).
 */
public class ClassAttendanceTracker {

    public static class AttendanceResult {
        public final int presentDays;
        public final int longestStreak;

        public AttendanceResult(int presentDays, int longestStreak) {
            this.presentDays = presentDays;
            this.longestStreak = longestStreak;
        }

        @Override
        public String toString() {
            return "Present: " + presentDays + ", Longest streak: " + longestStreak;
        }
    }

    public static AttendanceResult attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new AttendanceResult(0, 0);
        }

        int totalPresent = 0;
        int currentStreak = 0;
        int maxStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceResult(totalPresent, maxStreak);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ").replace("days =", "");
            Scanner ls = new Scanner(line);
            while (ls.hasNextInt()) {
                list.add(ls.nextInt());
            }
            ls.close();
        }

        if (!list.isEmpty()) {
            int[] arr = list.stream().mapToInt(i -> i).toArray();
            System.out.println(attendanceSummary(arr));
        } else {
            // Default sample demo
            System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
            System.out.println(attendanceSummary(new int[]{0, 0, 0}));
        }
        scanner.close();
    }
}
