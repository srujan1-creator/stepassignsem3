import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C · SORTING ALGORITHMS
 * Problem 3: The Library Book Shelf
 *
 * Task:
 * A library helper puts books on a shelf one at a time. The books already on the
 * shelf are always kept in increasing order of book number, and each new book slides
 * into its correct place. Write a method shelf(int[] books) that sorts the array
 * this way and prints the shelf after each book (from the second book onwards)
 * has been placed.
 *
 * Example:
 * Sample Input: books = [30, 10, 40, 20]
 * Expected Output:
 * After placing 10: [10, 30, 40, 20]
 * After placing 40: [10, 30, 40, 20]
 * After placing 20: [10, 20, 30, 40]
 */
public class LibraryBookShelf {

    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        int n = books.length;
        for (int i = 1; i < n; i++) {
            int currentBook = books[i];
            int j = i - 1;

            // Shift elements that are greater than currentBook to one position ahead
            while (j >= 0 && books[j] > currentBook) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = currentBook;

            System.out.println("After placing " + currentBook + ": " + Arrays.toString(books));
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
                shelf(arr);
            }
        } else {
            // Default sample demo
            System.out.println("--- Sample Input ---");
            shelf(new int[]{30, 10, 40, 20});

            System.out.println("--- Custom Test Case ---");
            shelf(new int[]{55, 33, 11, 22, 44});
        }
        scanner.close();
    }
}
