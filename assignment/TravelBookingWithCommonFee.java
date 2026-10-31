import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Assignment
 * Part A — Problem 5: Travel Booking with a Common Fee
 *
 * Task:
 * A travel website sells bus, train, and flight tickets. The fare depends on the travel mode
 * and the distance, but every booking — whatever the mode — also adds the same booking fee
 * of 50. The fee must be written in one place only.
 * If the booking fee changes, only one line of code should need to change.
 *
 * Input:
 * First line: N
 * Next N lines: MODE distanceKm (where MODE is BUS, TRAIN, or FLIGHT)
 *
 * Output:
 * For each booking: MODE: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Bus fare: 2 per km.
 * - Train fare: 1.5 per km.
 * - Flight fare: 2500 plus 4 per km.
 * - Every booking adds a booking fee of 50 to the fare.
 *
 * OOP Design:
 * - `abstract class TravelBooking`: Houses the single source of truth for `BOOKING_FEE = 50.0`.
 *   Provides template method `calculateTotalFare() = calculateBaseFare() + BOOKING_FEE`.
 *   Mandates the abstract method `calculateBaseFare()`.
 * - Subclasses:
 *   - `BusBooking`: 2.0 * distanceKm
 *   - `TrainBooking`: 1.5 * distanceKm
 *   - `FlightBooking`: 2500.0 + (4.0 * distanceKm)
 */
public class TravelBookingWithCommonFee {

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class TravelBooking {
        // Shared booking fee defined in exactly one place
        public static final double BOOKING_FEE = 50.0;

        protected final String mode;
        protected final double distanceKm;

        public TravelBooking(String mode, double distanceKm) {
            this.mode = mode;
            this.distanceKm = Math.max(0.0, distanceKm);
        }

        public String getMode() {
            return mode;
        }

        public double getDistanceKm() {
            return distanceKm;
        }

        // Each travel mode uniquely defines how its base distance-dependent fare is computed
        public abstract double calculateBaseFare();

        // Template method: base fare + common booking fee
        public double calculateTotalFare() {
            return calculateBaseFare() + BOOKING_FEE;
        }
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class BusBooking extends TravelBooking {
        private static final double RATE_PER_KM = 2.0;

        public BusBooking(double distanceKm) {
            super("BUS", distanceKm);
        }

        @Override
        public double calculateBaseFare() {
            return distanceKm * RATE_PER_KM;
        }
    }

    public static class TrainBooking extends TravelBooking {
        private static final double RATE_PER_KM = 1.5;

        public TrainBooking(double distanceKm) {
            super("TRAIN", distanceKm);
        }

        @Override
        public double calculateBaseFare() {
            return distanceKm * RATE_PER_KM;
        }
    }

    public static class FlightBooking extends TravelBooking {
        private static final double BASE_AIRPORT_FARE = 2500.0;
        private static final double RATE_PER_KM = 4.0;

        public FlightBooking(double distanceKm) {
            super("FLIGHT", distanceKm);
        }

        @Override
        public double calculateBaseFare() {
            return BASE_AIRPORT_FARE + (distanceKm * RATE_PER_KM);
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static TravelBooking createBooking(String mode, double distanceKm) {
        if (mode == null) {
            throw new IllegalArgumentException("Travel mode cannot be null");
        }
        switch (mode.trim().toUpperCase()) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            case "FLIGHT":
                return new FlightBooking(distanceKm);
            default:
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
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
        List<TravelBooking> bookings = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            bookings.add(createBooking(mode, distance));
        }

        for (TravelBooking booking : bookings) {
            double total = booking.calculateTotalFare();
            System.out.printf(Locale.US, "%s: %.2f%n", booking.getMode(), total);
        }

        scanner.close();
    }
}
