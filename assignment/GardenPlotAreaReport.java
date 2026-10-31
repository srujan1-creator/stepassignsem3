import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Assignment
 * Part A — Problem 1: Garden Plot Area Report
 *
 * Task:
 * A community garden rents out plots of three shapes: circular, rectangular, and triangular.
 * Every plot has an owner, and every plot's area is calculated with a different formula.
 * The garden office needs the area of each plot and the total area rented.
 * Adding a new plot shape later should not require changes to the code that prints the report.
 *
 * Input:
 * First line: N (number of plots)
 * Next N lines:
 *   CIRCLE Owner radius
 *   RECTANGLE Owner length width
 *   TRIANGLE Owner base height
 *
 * Output:
 * For each plot: Owner (SHAPE): area
 * Finally: Total Area: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Circle area = π × radius × radius (using Math.PI).
 * - Rectangle area = length × width.
 * - Triangle area = ½ × base × height.
 *
 * OOP Design:
 * - `abstract class GardenPlot`: Defines common attributes (`owner`, `shapeName`) and mandates
 *   the abstract method `calculateArea()`.
 * - Extensibility (Open/Closed Principle): New plot shapes can be added by extending `GardenPlot`
 *   without altering the reporting or aggregation logic.
 * - Subclasses: `CirclePlot`, `RectanglePlot`, `TrianglePlot`.
 */
public class GardenPlotAreaReport {

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class GardenPlot {
        protected final String owner;
        protected final String shapeName;

        public GardenPlot(String owner, String shapeName) {
            this.owner = owner;
            this.shapeName = shapeName;
        }

        public String getOwner() {
            return owner;
        }

        public String getShapeName() {
            return shapeName;
        }

        // Each shape implements its unique mathematical area formula
        public abstract double calculateArea();

        // Formats individual plot line
        public String formatReport() {
            return String.format(Locale.US, "%s (%s): %.2f", owner, shapeName, calculateArea());
        }
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class CirclePlot extends GardenPlot {
        private final double radius;

        public CirclePlot(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class RectanglePlot extends GardenPlot {
        private final double length;
        private final double width;

        public RectanglePlot(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    public static class TrianglePlot extends GardenPlot {
        private final double base;
        private final double height;

        public TrianglePlot(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        public double getBase() {
            return base;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static GardenPlot createPlot(String[] parts) {
        String shape = parts[0].trim().toUpperCase();
        String owner = parts[1].trim();

        switch (shape) {
            case "CIRCLE":
                double radius = Double.parseDouble(parts[2]);
                return new CirclePlot(owner, radius);
            case "RECTANGLE":
                double length = Double.parseDouble(parts[2]);
                double width = Double.parseDouble(parts[3]);
                return new RectanglePlot(owner, length, width);
            case "TRIANGLE":
                double base = Double.parseDouble(parts[2]);
                double height = Double.parseDouble(parts[3]);
                return new TrianglePlot(owner, base, height);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shape);
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
        List<GardenPlot> plots = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }
            if (line.isEmpty()) break;

            String[] parts = line.split("\\s+");
            plots.add(createPlot(parts));
        }

        double totalArea = 0.0;
        // Reporting code remains closed for modification when new shapes are added
        for (GardenPlot plot : plots) {
            System.out.println(plot.formatReport());
            totalArea += plot.calculateArea();
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
        scanner.close();
    }
}
