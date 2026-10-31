import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Practice Coding Assignment
 * Problem 4: City Cab Fare Meter
 *
 * Task:
 * A cab company runs three kinds of cabs: mini, sedan, and SUV. Each cab type charges
 * a different rate per kilometre, but the company has one rule for all cabs: no trip
 * costs less than 100. Only sedans and SUVs offer night service, which adds 20% to the fare.
 * A night trip requested in a mini must be rejected.
 * The company needs the fare for every completed trip and the total of all completed trips.
 *
 * Input:
 * First line: N
 * Next N lines: CAB km TIME (where CAB is MINI, SEDAN, or SUV and TIME is DAY or NIGHT)
 *
 * Output:
 * For each completed trip: CAB: fare
 * For a rejected trip: CAB: night service not available
 * Finally: Total: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Mini: 10 per km. Sedan: 14 per km. SUV: 18 per km.
 * - Fare = distance * rate, but never less than 100.
 * - A night trip adds 20% to the fare (after the minimum is applied).
 * - A rejected trip does not add to total.
 *
 * OOP Design:
 * - Interface `NightServiceCapable`: Represents the ability to operate at night.
 * - Abstract class `Cab`: Implements the shared minimum-fare policy (`MINIMUM_FARE = 100.0`)
 *   and mandates `getRatePerKm()`.
 * - Subclasses `MiniCab`, `SedanCab`, and `SuvCab`. Only `SedanCab` and `SuvCab` implement
 *   `NightServiceCapable`.
 */
public class CityCabFareMeter {

    // ==========================================
    // Capability Interface
    // ==========================================
    public interface NightServiceCapable {
        double NIGHT_SURCHARGE_RATE = 0.20; // +20%

        default double applyNightSurcharge(double baseFare) {
            return baseFare * (1.0 + NIGHT_SURCHARGE_RATE);
        }
    }

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class Cab {
        // Shared minimum fare policy enforced in one single place
        public static final double MINIMUM_FARE = 100.0;

        protected final String type;

        public Cab(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        // Subclass-specific rate per kilometre
        public abstract double getRatePerKm();

        // Ability check via interface type check
        public boolean supportsNightService() {
            return this instanceof NightServiceCapable;
        }

        // Shared fare calculation logic
        public double calculateTripFare(double km, boolean isNight) {
            if (isNight && !supportsNightService()) {
                throw new UnsupportedOperationException("night service not available");
            }

            double rawFare = km * getRatePerKm();
            double fare = Math.max(MINIMUM_FARE, rawFare);

            if (isNight) {
                fare = ((NightServiceCapable) this).applyNightSurcharge(fare);
            }

            return fare;
        }
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class MiniCab extends Cab {
        public static final double RATE_PER_KM = 10.0;

        public MiniCab() {
            super("MINI");
        }

        @Override
        public double getRatePerKm() {
            return RATE_PER_KM;
        }
    }

    public static class SedanCab extends Cab implements NightServiceCapable {
        public static final double RATE_PER_KM = 14.0;

        public SedanCab() {
            super("SEDAN");
        }

        @Override
        public double getRatePerKm() {
            return RATE_PER_KM;
        }
    }

    public static class SuvCab extends Cab implements NightServiceCapable {
        public static final double RATE_PER_KM = 18.0;

        public SuvCab() {
            super("SUV");
        }

        @Override
        public double getRatePerKm() {
            return RATE_PER_KM;
        }
    }

    // ==========================================
    // Booking Trip Model
    // ==========================================
    public static class TripRequest {
        private final Cab cab;
        private final double km;
        private final boolean isNight;

        public TripRequest(Cab cab, double km, boolean isNight) {
            this.cab = cab;
            this.km = km;
            this.isNight = isNight;
        }

        public Cab getCab() {
            return cab;
        }

        public double getKm() {
            return km;
        }

        public boolean isNight() {
            return isNight;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static Cab createCab(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Cab type cannot be null");
        }
        switch (type.trim().toUpperCase()) {
            case "MINI":
                return new MiniCab();
            case "SEDAN":
                return new SedanCab();
            case "SUV":
                return new SuvCab();
            default:
                throw new IllegalArgumentException("Unknown cab type: " + type);
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
        List<TripRequest> requests = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = "NIGHT".equalsIgnoreCase(time.trim());
            requests.add(new TripRequest(createCab(cabType), km, isNight));
        }

        double totalCompletedFare = 0.0;
        for (TripRequest request : requests) {
            Cab cab = request.getCab();
            try {
                double fare = cab.calculateTripFare(request.getKm(), request.isNight());
                System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
                totalCompletedFare += fare;
            } catch (UnsupportedOperationException e) {
                System.out.printf(Locale.US, "%s: %s%n", cab.getType(), e.getMessage());
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", totalCompletedFare);
        scanner.close();
    }
}
