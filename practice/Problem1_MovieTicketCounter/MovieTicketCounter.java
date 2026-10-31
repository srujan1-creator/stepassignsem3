import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Practice Coding Assignment
 * Problem 1: Movie Ticket Counter
 *
 * Task:
 * A cinema sells three kinds of seats: regular, premium, and recliner.
 * Each seat type has its own ticket price, but every ticket — whatever the seat type —
 * also carries the same convenience fee of 20. The fee must be written in one place only.
 * The counter needs the amount for each booking and the total collected.
 * A plain "ticket" with no seat type must never be sold.
 *
 * Input:
 * First line: N (number of bookings)
 * Next N lines: SEAT count (REGULAR, PREMIUM, or RECLINER; count is integer)
 *
 * Output:
 * For each booking: SEAT: amount
 * Finally: Total: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Regular seat: 150 per ticket.
 * - Premium seat: 250 per ticket.
 * - Recliner seat: 400 per ticket.
 * - Every ticket adds a convenience fee of 20.
 *
 * OOP Design:
 * - `abstract class Ticket`: Mandates that generic tickets cannot be instantiated directly.
 *   Holds common state (`seatType`, `count`) and shared convenience fee (`CONVENIENCE_FEE = 20.0`).
 *   Defines abstract method `getPricePerTicket()`.
 * - Subclasses `RegularTicket`, `PremiumTicket`, and `ReclinerTicket` override `getPricePerTicket()`.
 */
public class MovieTicketCounter {

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class Ticket {
        // Shared convenience fee defined in exactly one place
        public static final double CONVENIENCE_FEE = 20.0;

        protected final String seatType;
        protected final int count;

        public Ticket(String seatType, int count) {
            this.seatType = seatType;
            this.count = count;
        }

        public String getSeatType() {
            return seatType;
        }

        public int getCount() {
            return count;
        }

        // Abstract method: each seat type defines its unique ticket price
        public abstract double getPricePerTicket();

        // Template calculation: (price + convenience fee) * count
        public double calculateTotalAmount() {
            return (getPricePerTicket() + CONVENIENCE_FEE) * count;
        }
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class RegularTicket extends Ticket {
        public static final double PRICE = 150.0;

        public RegularTicket(int count) {
            super("REGULAR", count);
        }

        @Override
        public double getPricePerTicket() {
            return PRICE;
        }
    }

    public static class PremiumTicket extends Ticket {
        public static final double PRICE = 250.0;

        public PremiumTicket(int count) {
            super("PREMIUM", count);
        }

        @Override
        public double getPricePerTicket() {
            return PRICE;
        }
    }

    public static class ReclinerTicket extends Ticket {
        public static final double PRICE = 400.0;

        public ReclinerTicket(int count) {
            super("RECLINER", count);
        }

        @Override
        public double getPricePerTicket() {
            return PRICE;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static Ticket createTicket(String seatType, int count) {
        if (seatType == null) {
            throw new IllegalArgumentException("Seat type cannot be null");
        }
        switch (seatType.trim().toUpperCase()) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            case "RECLINER":
                return new ReclinerTicket(count);
            default:
                throw new IllegalArgumentException("Invalid seat type: " + seatType);
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
        List<Ticket> bookings = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            bookings.add(createTicket(seat, count));
        }

        double totalCollected = 0.0;
        for (Ticket ticket : bookings) {
            double amount = ticket.calculateTotalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", ticket.getSeatType(), amount);
            totalCollected += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", totalCollected);
        scanner.close();
    }
}
