import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Assignment
 * Part A — Problem 4: Electricity Connection Billing
 *
 * Task:
 * The electricity board issues monthly bills to homes, shops, and factories. Every connection
 * has a number of units used, but each connection type calculates its bill differently.
 * The board needs each connection's bill and the total amount billed.
 *
 * Input:
 * First line: N
 * Next N lines: TYPE units (TYPE is HOME, SHOP, or FACTORY; units is a number)
 *
 * Output:
 * For each connection: TYPE: bill
 * Finally: Total: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Home: 5 per unit for the first 100 units and 7 per unit after that.
 * - Shop: 8 per unit plus a fixed charge of 100.
 * - Factory: 6 per unit, with a minimum bill of 1000.
 *
 * OOP Design:
 * - `abstract class ElectricityConnection`: Shared base class holding `type` and `units`,
 *   and defining abstract method `calculateBill()`.
 * - Subclasses:
 *   - `HomeConnection`: Implements slab pricing (5/unit for <=100, 7/unit thereafter).
 *   - `ShopConnection`: Implements per-unit rate (8/unit) + fixed charge (100).
 *   - `FactoryConnection`: Implements industrial per-unit rate (6/unit) with floor minimum (1000).
 */
public class ElectricityConnectionBilling {

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class ElectricityConnection {
        protected final String type;
        protected final double units;

        public ElectricityConnection(String type, double units) {
            this.type = type;
            this.units = Math.max(0.0, units);
        }

        public String getType() {
            return type;
        }

        public double getUnits() {
            return units;
        }

        // Abstract method: each connection type implements its unique billing policy
        public abstract double calculateBill();
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class HomeConnection extends ElectricityConnection {
        private static final double TIER_1_LIMIT = 100.0;
        private static final double TIER_1_RATE = 5.0;
        private static final double TIER_2_RATE = 7.0;

        public HomeConnection(double units) {
            super("HOME", units);
        }

        @Override
        public double calculateBill() {
            if (units <= TIER_1_LIMIT) {
                return units * TIER_1_RATE;
            } else {
                double tier1Cost = TIER_1_LIMIT * TIER_1_RATE;
                double excessUnits = units - TIER_1_LIMIT;
                double tier2Cost = excessUnits * TIER_2_RATE;
                return tier1Cost + tier2Cost;
            }
        }
    }

    public static class ShopConnection extends ElectricityConnection {
        private static final double PER_UNIT_RATE = 8.0;
        private static final double FIXED_CHARGE = 100.0;

        public ShopConnection(double units) {
            super("SHOP", units);
        }

        @Override
        public double calculateBill() {
            return (units * PER_UNIT_RATE) + FIXED_CHARGE;
        }
    }

    public static class FactoryConnection extends ElectricityConnection {
        private static final double PER_UNIT_RATE = 6.0;
        private static final double MINIMUM_BILL = 1000.0;

        public FactoryConnection(double units) {
            super("FACTORY", units);
        }

        @Override
        public double calculateBill() {
            double calculated = units * PER_UNIT_RATE;
            return Math.max(MINIMUM_BILL, calculated);
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static ElectricityConnection createConnection(String type, double units) {
        if (type == null) {
            throw new IllegalArgumentException("Connection type cannot be null");
        }
        switch (type.trim().toUpperCase()) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
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
        List<ElectricityConnection> connections = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            connections.add(createConnection(type, units));
        }

        double grandTotal = 0.0;
        for (ElectricityConnection connection : connections) {
            double bill = connection.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", connection.getType(), bill);
            grandTotal += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
