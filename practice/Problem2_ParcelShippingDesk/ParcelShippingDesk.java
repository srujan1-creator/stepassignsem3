import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Practice Coding Assignment
 * Problem 2: Parcel Shipping Desk
 *
 * Task:
 * A courier office ships standard, express, and fragile parcels. Every parcel has a weight
 * and a declared value, and each parcel type calculates its shipping charge differently.
 * Express and fragile parcels can also be insured; standard parcels cannot.
 *
 * The office needs the charge, the insurance, and the total for each parcel, followed by
 * the grand total. Making another parcel type insurable later should not change the parcel
 * types that are not insured.
 *
 * Input:
 * First line: N
 * Next N lines: TYPE weightKg declaredValue (STANDARD, EXPRESS, or FRAGILE)
 *
 * Output:
 * For each parcel: TYPE: Charge=c Insurance=i Total=t
 * Finally: Grand Total: g
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Standard: 40 plus 10 per kg.
 * - Express: 80 plus 15 per kg.
 * - Fragile: the standard charge plus a handling fee of 50.
 * - Insurance for express and fragile parcels is 2% of the declared value. Standard parcels show Insurance=0.00.
 *
 * OOP Design:
 * - Interface `Insurable`: Segregates the insurance capability from the base parcel hierarchy
 *   (Interface Segregation Principle).
 * - Abstract class `Parcel`: Defines common parcel attributes (`type`, `weightKg`, `declaredValue`)
 *   and mandates `calculateShippingCharge()`. Standard parcels do not implement `Insurable`.
 * - Subclasses `StandardParcel`, `ExpressParcel`, and `FragileParcel`.
 */
public class ParcelShippingDesk {

    // ==========================================
    // Capability Interface
    // ==========================================
    public interface Insurable {
        double INSURANCE_RATE = 0.02; // 2% of declared value

        default double calculateInsurance(double declaredValue) {
            return declaredValue * INSURANCE_RATE;
        }
    }

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class Parcel {
        protected final String type;
        protected final double weightKg;
        protected final double declaredValue;

        public Parcel(String type, double weightKg, double declaredValue) {
            this.type = type;
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public String getType() {
            return type;
        }

        public double getWeightKg() {
            return weightKg;
        }

        public double getDeclaredValue() {
            return declaredValue;
        }

        // Abstract method: each parcel type calculates its base shipping charge differently
        public abstract double calculateShippingCharge();

        // Determines insurance polymorphically via capability check
        public double getInsuranceAmount() {
            if (this instanceof Insurable) {
                return ((Insurable) this).calculateInsurance(this.declaredValue);
            }
            return 0.0;
        }

        public double calculateTotal() {
            return calculateShippingCharge() + getInsuranceAmount();
        }
    }

    // ==========================================
    // Concrete Parcel Subclasses
    // ==========================================
    public static class StandardParcel extends Parcel {
        private static final double BASE_RATE = 40.0;
        private static final double PER_KG_RATE = 10.0;

        public StandardParcel(double weightKg, double declaredValue) {
            super("STANDARD", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return BASE_RATE + (PER_KG_RATE * weightKg);
        }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        private static final double BASE_RATE = 80.0;
        private static final double PER_KG_RATE = 15.0;

        public ExpressParcel(double weightKg, double declaredValue) {
            super("EXPRESS", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return BASE_RATE + (PER_KG_RATE * weightKg);
        }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        private static final double STANDARD_BASE = 40.0;
        private static final double STANDARD_PER_KG = 10.0;
        private static final double HANDLING_FEE = 50.0;

        public FragileParcel(double weightKg, double declaredValue) {
            super("FRAGILE", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            // standard charge plus handling fee of 50
            double standardCharge = STANDARD_BASE + (STANDARD_PER_KG * weightKg);
            return standardCharge + HANDLING_FEE;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static Parcel createParcel(String type, double weightKg, double declaredValue) {
        if (type == null) {
            throw new IllegalArgumentException("Parcel type cannot be null");
        }
        switch (type.trim().toUpperCase()) {
            case "STANDARD":
                return new StandardParcel(weightKg, declaredValue);
            case "EXPRESS":
                return new ExpressParcel(weightKg, declaredValue);
            case "FRAGILE":
                return new FragileParcel(weightKg, declaredValue);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + type);
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
        List<Parcel> parcels = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredVal = scanner.nextDouble();
            parcels.add(createParcel(type, weight, declaredVal));
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.getInsuranceAmount();
            double total = parcel.calculateTotal();

            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
            grandTotal += total;
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
