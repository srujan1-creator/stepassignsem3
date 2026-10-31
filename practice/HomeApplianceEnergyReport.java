import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Practice Coding Assignment
 * Problem 5: Home Appliance Energy Report
 *
 * Task:
 * An energy app estimates the monthly electricity cost of four home appliances:
 * a fridge, an air conditioner, a TV, and a washing machine. Every appliance has
 * a fixed power rating and a number of hours used. The air conditioner and the
 * washing machine also have a saver mode that reduces their energy use by 25%;
 * the fridge and the TV do not.
 *
 * The app must show the units used and the cost for each appliance, and the total cost.
 * If saver mode is requested for an appliance that does not support it, the app must
 * report it instead of calculating a cost.
 *
 * Input:
 * First line: N
 * Next N lines: APPLIANCE hours [SAVER] (FRIDGE, AC, TV, or WASHER)
 *
 * Output:
 * For each appliance: APPLIANCE: Units=u Cost=c
 * OR: APPLIANCE: saver mode not supported
 * Finally: Total Cost: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Power ratings: Fridge 150 W, AC 1500 W, TV 100 W, Washer 500 W.
 * - Units (kWh) = power * hours / 1000. In saver mode, units are reduced by 25%.
 * - Cost = units * 8.
 *
 * OOP Design:
 * - Interface `SaverModeCapable`: Marker/behavioral interface for appliances with saver mode capability.
 * - Abstract class `Appliance`: Encapsulates common state (`name`) and implements standard units & cost calculations.
 *   Throws `UnsupportedOperationException` if saver mode is requested on an unsupported appliance.
 * - Concrete subclasses: `Fridge`, `AirConditioner`, `Television`, `WashingMachine`.
 */
public class HomeApplianceEnergyReport {

    // ==========================================
    // Capability Interface
    // ==========================================
    public interface SaverModeCapable {
        double SAVER_DISCOUNT = 0.25; // 25% reduction in units
    }

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class Appliance {
        public static final double COST_PER_UNIT = 8.0;

        protected final String name;

        public Appliance(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // Fixed wattage defined by each appliance subtype
        public abstract double getPowerWatts();

        // Checks support dynamically via interface implementation
        public boolean supportsSaverMode() {
            return this instanceof SaverModeCapable;
        }

        public double calculateUnits(double hours, boolean isSaver) {
            if (isSaver && !supportsSaverMode()) {
                throw new UnsupportedOperationException("saver mode not supported");
            }

            double units = (getPowerWatts() * hours) / 1000.0;
            if (isSaver) {
                units *= (1.0 - SaverModeCapable.SAVER_DISCOUNT);
            }
            return units;
        }

        public double calculateCost(double units) {
            return units * COST_PER_UNIT;
        }
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class Fridge extends Appliance {
        public Fridge() {
            super("FRIDGE");
        }

        @Override
        public double getPowerWatts() {
            return 150.0;
        }
    }

    public static class AirConditioner extends Appliance implements SaverModeCapable {
        public AirConditioner() {
            super("AC");
        }

        @Override
        public double getPowerWatts() {
            return 1500.0;
        }
    }

    public static class Television extends Appliance {
        public Television() {
            super("TV");
        }

        @Override
        public double getPowerWatts() {
            return 100.0;
        }
    }

    public static class WashingMachine extends Appliance implements SaverModeCapable {
        public WashingMachine() {
            super("WASHER");
        }

        @Override
        public double getPowerWatts() {
            return 500.0;
        }
    }

    // ==========================================
    // Usage Request Model
    // ==========================================
    public static class UsageRecord {
        private final Appliance appliance;
        private final double hours;
        private final boolean isSaver;

        public UsageRecord(Appliance appliance, double hours, boolean isSaver) {
            this.appliance = appliance;
            this.hours = hours;
            this.isSaver = isSaver;
        }

        public Appliance getAppliance() {
            return appliance;
        }

        public double getHours() {
            return hours;
        }

        public boolean isSaver() {
            return isSaver;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static Appliance createAppliance(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Appliance name cannot be null");
        }
        switch (name.trim().toUpperCase()) {
            case "FRIDGE":
                return new Fridge();
            case "AC":
                return new AirConditioner();
            case "TV":
                return new Television();
            case "WASHER":
                return new WashingMachine();
            default:
                throw new IllegalArgumentException("Unknown appliance: " + name);
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
        scanner.nextLine(); // consume newline
        List<UsageRecord> records = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }
            if (line.isEmpty()) break;

            String[] parts = line.split("\\s+");
            String applianceName = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaver = (parts.length > 2 && "SAVER".equalsIgnoreCase(parts[2]));

            records.add(new UsageRecord(createAppliance(applianceName), hours, isSaver));
        }

        double totalCost = 0.0;
        for (UsageRecord record : records) {
            Appliance appliance = record.getAppliance();
            try {
                double units = appliance.calculateUnits(record.getHours(), record.isSaver());
                double cost = appliance.calculateCost(units);
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                totalCost += cost;
            } catch (UnsupportedOperationException e) {
                System.out.printf(Locale.US, "%s: %s%n", appliance.getName(), e.getMessage());
            }
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
