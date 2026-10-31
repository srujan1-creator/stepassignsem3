import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Coding Assignment
 * Problem 10: Busiest Bus Row
 *
 * Task:
 * A college bus records how many students sit in each seat as a 2D grid, where
 * each row is one row of seats. The transport office wants to know which row
 * carries the most students.
 *
 * Implement a function busiestRow(grid) that returns the index of the row with
 * the largest total and that total. If two rows tie, return the one with the smaller index.
 *
 * Constraints:
 * - 1 <= rows, columns <= 10
 * - 0 <= grid[i][j] <= 3
 *
 * Example:
 * grid = [[2, 0, 1],
 *         [3, 3, 1],
 *         [1, 1, 1]]
 * Expected Output: Row 1, Total 7
 *
 * Complexity Requirements:
 * - Time Complexity: O(r * c) where r is rows and c is columns.
 * - Auxiliary Space Complexity: O(1).
 */
public class BusiestBusRow {

    public static class RowResult {
        public final int rowIndex;
        public final int totalStudents;

        public RowResult(int rowIndex, int totalStudents) {
            this.rowIndex = rowIndex;
            this.totalStudents = totalStudents;
        }

        @Override
        public String toString() {
            return "Row " + rowIndex + ", Total " + totalStudents;
        }
    }

    public static RowResult busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new RowResult(0, 0);
        }

        int maxRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowSum += grid[r][c];
            }

            // Strictly greater ensures smaller index is retained on ties
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                maxRow = r;
            }
        }

        return new RowResult(maxRow, maxTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Default sample demo
        int[][] sampleGrid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.println(busiestRow(sampleGrid));
        scanner.close();
    }
}
