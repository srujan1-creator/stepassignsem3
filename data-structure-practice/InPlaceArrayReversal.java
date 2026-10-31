import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 4: In-Place Array Reversal
 *
 * Task:
 * Write a program that reverses the order of token numbers stored in a list.
 * The reversal must be done 'in-place', meaning you should modify the original
 * list directly without creating a second list.
 *
 * Example:
 * Input: [11, 22, 33, 44]
 * Output: [44, 33, 22, 11]
 *
 * Hint:
 * Use two pointers, one starting from the beginning and one from the end of the array.
 * Swap the elements at these pointers and move them towards the center until they meet or cross.
 */
public class InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNextInt()) {
                list.add(lineScanner.nextInt());
            }
            lineScanner.close();
        }

        int[] arr;
        if (!list.isEmpty()) {
            arr = list.stream().mapToInt(i -> i).toArray();
        } else {
            arr = new int[]{11, 22, 33, 44};
        }

        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
