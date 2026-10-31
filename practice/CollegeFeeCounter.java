import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Practice Coding Assignment
 * Problem 3: College Fee Counter
 *
 * Task:
 * A college collects yearly fees from three kinds of students: day scholars, hostellers,
 * and scholarship students. Every student has a name and pays tuition, but the amount
 * and the extra charges differ. Day scholars and scholarship students use the college bus;
 * hostellers live on campus and do not.
 * The fee counter needs each student's total fee and the total collected.
 *
 * Input:
 * First line: N
 * Next N lines: TYPE Name (TYPE is DAY_SCHOLAR, HOSTELLER, or SCHOLAR)
 *
 * Output:
 * For each student: Name: fee
 * Finally: Total Collected: total
 * All values formatted to two decimal places.
 *
 * Business Rules:
 * - Day scholar: tuition 40000.
 * - Hosteller: tuition 40000 plus hostel fee 60000.
 * - Scholarship student: half of normal tuition (20000).
 * - Every student who uses the college bus pays a transport fee of 12000.
 *
 * OOP Design:
 * - Interface `BusTransportUser`: Mandates bus transport capability and encapsulates the
 *   single source of truth for the `TRANSPORT_FEE = 12000.0`.
 * - Abstract class `Student`: Encapsulates common student properties (`name`) and mandates
 *   the abstract method `calculateTuition()`.
 * - Template method `calculateTotalFee()` uniformly adds the transport fee polymorphically
 *   if the student implements `BusTransportUser`, without checking student type by name.
 */
public class CollegeFeeCounter {

    // ==========================================
    // Capability Interface
    // ==========================================
    public interface BusTransportUser {
        double TRANSPORT_FEE = 12000.0;

        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    // ==========================================
    // Abstract Base Class
    // ==========================================
    public static abstract class Student {
        public static final double BASE_TUITION = 40000.0;

        protected final String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // Subclasses compute their tuition component
        public abstract double calculateTuition();

        // Common template method: tuition + optional bus transport fee
        public double calculateTotalFee() {
            double total = calculateTuition();
            if (this instanceof BusTransportUser) {
                total += ((BusTransportUser) this).getTransportFee();
            }
            return total;
        }
    }

    // ==========================================
    // Concrete Subclasses
    // ==========================================
    public static class DayScholar extends Student implements BusTransportUser {
        public DayScholar(String name) {
            super(name);
        }

        @Override
        public double calculateTuition() {
            return BASE_TUITION; // 40000
        }
    }

    public static class Hosteller extends Student {
        public static final double HOSTEL_FEE = 60000.0;

        public Hosteller(String name) {
            super(name);
        }

        @Override
        public double calculateTuition() {
            return BASE_TUITION + HOSTEL_FEE; // 40000 + 60000 = 100000
        }
    }

    public static class ScholarshipStudent extends Student implements BusTransportUser {
        public ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        public double calculateTuition() {
            return BASE_TUITION / 2.0; // half of normal tuition = 20000
        }
    }

    // ==========================================
    // Factory Method
    // ==========================================
    public static Student createStudent(String type, String name) {
        if (type == null) {
            throw new IllegalArgumentException("Student type cannot be null");
        }
        switch (type.trim().toUpperCase()) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                throw new IllegalArgumentException("Unknown student type: " + type);
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
        List<Student> students = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            students.add(createStudent(type, name));
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", student.getName(), fee);
            totalCollected += fee;
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
