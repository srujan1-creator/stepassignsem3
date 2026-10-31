import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Coding Assignment
 * Problem 7: Second-Best Score
 *
 * Task:
 * A quiz app stores the scores of all players in an array. Prizes go to the top two
 * different scores, so the app needs the second-highest distinct score. If every
 * player has the same score, there is no second-highest score.
 *
 * Implement a function secondHighest(scores) that returns the second-highest distinct
 * score, or -1 if it does not exist.
 *
 * Constraints:
 * - 1 <= length of scores <= 1000
 * - 0 <= scores[i] <= 100
 * - Do not sort the array
 *
 * Examples:
 * Sample 1:
 * scores = [45, 78, 92, 78, 60]
 * Expected Output: 78
 *
 * Sample 2:
 * scores = [50, 50, 50]
 * Expected Output: -1
 *
 * Complexity Requirements:
 * - Time Complexity: O(N) single pass.
 *   (Sorting would take O(N log N) time and would violate the 'do not sort' rule).
 * - Auxiliary Space Complexity: O(1).
 */
public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ").replace("scores =", "");
            Scanner ls = new Scanner(line);
            while (ls.hasNextInt()) {
                list.add(ls.nextInt());
            }
            ls.close();
        }

        if (!list.isEmpty()) {
            int[] arr = list.stream().mapToInt(i -> i).toArray();
            System.out.println(secondHighest(arr));
        } else {
            // Default sample demo
            System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
            System.out.println(secondHighest(new int[]{50, 50, 50}));
        }
        scanner.close();
    }
}
