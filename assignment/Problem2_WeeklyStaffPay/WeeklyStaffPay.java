import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Assignment
 * Part A — Problem 2: Weekly Staff Pay
 *
 * Task:
 * A small company pays three kinds of staff every week: full-time staff receive a fixed
 * weekly salary, hourly staff are paid by the hour with overtime, and interns receive
 * a fixed stipend. Every staff member has a name, and the payroll screen must list each
 * person's pay and the total.
 * A generic "staff member" with no pay rule must never be created.
 *
 * Input:
 * First line: N
 * Next N lines:
 *   FULLTIME Name weeklySalary
 *   HOURLY Name hours rate
 *   INTERN Name stipend
 *
 * Output:
 * For each person: Name: pay
 * Finally: Total Payroll: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Full-time staff are paid their fixed weekly salary.
 * - Hourly staff are paid rate for the first 40 hours and 1.5 × rate for every hour above 40.
 * - Interns are paid their fixed stipend.
 *
 * OOP Design:
 * - `abstract class StaffMember`: Defines the shared property (`name`) and marks `calculatePay()`
 *   as abstract. Prevents instantiation of a generic staff member.
 * - Subclasses:
 *   - `FullTimeStaff`: Implements fixed salary calculation.
 *   - `HourlyStaff`: Implements overtime calculation (standard up to 40h, 1.5x thereafter).
 *   - `InternStaff`: Implements fixed stipend calculation.
 */
public class WeeklyStaffPay {

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class StaffMember {
        protected final String name;

        public StaffMember(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // Abstract method: each staff type must implement its specific pay calculation
        public abstract double calculatePay();
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class FullTimeStaff extends StaffMember {
        private final double weeklySalary;

        public FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double calculatePay() {
            return weeklySalary;
        }
    }

    public static class HourlyStaff extends StaffMember {
        private static final double STANDARD_HOURS_LIMIT = 40.0;
        private static final double OVERTIME_MULTIPLIER = 1.5;

        private final double hoursWorked;
        private final double hourlyRate;

        public HourlyStaff(String name, double hoursWorked, double hourlyRate) {
            super(name);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculatePay() {
            if (hoursWorked <= STANDARD_HOURS_LIMIT) {
                return hoursWorked * hourlyRate;
            } else {
                double regularPay = STANDARD_HOURS_LIMIT * hourlyRate;
                double overtimeHours = hoursWorked - STANDARD_HOURS_LIMIT;
                double overtimePay = overtimeHours * (hourlyRate * OVERTIME_MULTIPLIER);
                return regularPay + overtimePay;
            }
        }
    }

    public static class InternStaff extends StaffMember {
        private final double stipend;

        public InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double calculatePay() {
            return stipend;
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static StaffMember createStaffMember(String[] parts) {
        String type = parts[0].trim().toUpperCase();
        String name = parts[1].trim();

        switch (type) {
            case "FULLTIME":
                double salary = Double.parseDouble(parts[2]);
                return new FullTimeStaff(name, salary);
            case "HOURLY":
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);
                return new HourlyStaff(name, hours, rate);
            case "INTERN":
                double stipend = Double.parseDouble(parts[2]);
                return new InternStaff(name, stipend);
            default:
                throw new IllegalArgumentException("Unknown staff type: " + type);
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
        List<StaffMember> staffList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }
            if (line.isEmpty()) break;

            String[] parts = line.split("\\s+");
            staffList.add(createStaffMember(parts));
        }

        double totalPayroll = 0.0;
        for (StaffMember staff : staffList) {
            double pay = staff.calculatePay();
            System.out.printf(Locale.US, "%s: %.2f%n", staff.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}
