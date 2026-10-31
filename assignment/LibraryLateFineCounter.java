import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Assignment
 * Part A — Problem 3: Library Late Fine Counter
 *
 * Task:
 * A library charges a fine when borrowed items are returned late. Books, DVDs, and
 * magazines each follow a different fine rule. Every item has a title and a number of
 * days late. The library needs the fine for each item and the total fines collected.
 *
 * Input:
 * First line: N
 * Next N lines: TYPE Title daysLate (TYPE is BOOK, DVD, or MAGAZINE; Title is one word)
 *
 * Output:
 * For each item: Title: fine
 * Finally: Total Fines: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Books: 2 per day late.
 * - DVDs: 5 per day late, up to a maximum of 50.
 * - Magazines: 1 per day late.
 *
 * OOP Design:
 * - `abstract class LibraryItem`: Common base abstraction providing properties `title`
 *   and `daysLate`, and mandating the abstract method `calculateFine()`.
 * - Subclasses:
 *   - `BookItem`: Multiplies daysLate by 2.0.
 *   - `DvdItem`: Multiplies daysLate by 5.0 capped at maximum 50.0.
 *   - `MagazineItem`: Multiplies daysLate by 1.0.
 */
public class LibraryLateFineCounter {

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class LibraryItem {
        protected final String title;
        protected final int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = Math.max(0, daysLate);
        }

        public String getTitle() {
            return title;
        }

        public int getDaysLate() {
            return daysLate;
        }

        // Abstract method: each item implements its specific fine calculation
        public abstract double calculateFine();
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class BookItem extends LibraryItem {
        private static final double RATE_PER_DAY = 2.0;

        public BookItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return daysLate * RATE_PER_DAY;
        }
    }

    public static class DvdItem extends LibraryItem {
        private static final double RATE_PER_DAY = 5.0;
        private static final double MAX_FINE = 50.0;

        public DvdItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            double fine = daysLate * RATE_PER_DAY;
            return Math.min(MAX_FINE, fine);
        }
    }

    public static class MagazineItem extends LibraryItem {
        private static final double RATE_PER_DAY = 1.0;

        public MagazineItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return daysLate * RATE_PER_DAY;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static LibraryItem createLibraryItem(String type, String title, int daysLate) {
        if (type == null) {
            throw new IllegalArgumentException("Item type cannot be null");
        }
        switch (type.trim().toUpperCase()) {
            case "BOOK":
                return new BookItem(title, daysLate);
            case "DVD":
                return new DvdItem(title, daysLate);
            case "MAGAZINE":
                return new MagazineItem(title, daysLate);
            default:
                throw new IllegalArgumentException("Unknown library item type: " + type);
        }
    }

    // ==========================================
    // Main Processing Engine
    // ==========================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            items.add(createLibraryItem(type, title, daysLate));
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
            totalFines += fine;
        }

        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
        scanner.close();
    }
}
