import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 10: Student Result Card Generator
 *
 * Task:
 * Design a system for student result cards. Each student has a name and an array of
 * three marks. Implement a method to calculate the student's average mark. Based on
 * the average, assign a grade using the following conditions:
 * - 'A' for average 90 or above
 * - 'B' for average 75 or more (up to 89.9)
 * - 'C' for average 60 to 74.9
 * - 'D' for average between 40 and 59 (inclusive)
 * - 'F' for average below 40
 *
 * Finally, print the student's name in capital letters, their average mark
 * (one decimal place), and their assigned grade.
 *
 * Example:
 * Input:
 * Asha [80, 90, 70]
 * Ravi [60, 55, 50]
 * Output:
 * ASHA: Average 80.0, Grade B
 * RAVI: Average 55.0, Grade D
 */
public class StudentResultCardGenerator {

    public static class Student {
        private final String name;
        private final int[] marks;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public double calculateAverage() {
            if (marks == null || marks.length == 0) return 0.0;
            double sum = 0.0;
            for (int mark : marks) {
                sum += mark;
            }
            return sum / marks.length;
        }

        public char calculateGrade() {
            double avg = calculateAverage();
            if (avg >= 90.0) {
                return 'A';
            } else if (avg >= 75.0) {
                return 'B';
            } else if (avg >= 60.0) {
                return 'C';
            } else if (avg >= 40.0) {
                return 'D';
            } else {
                return 'F';
            }
        }

        public void printResultCard() {
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(Locale.US), calculateAverage(), calculateGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean processedAny = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            // Example line: Asha [80, 90, 70]
            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');
            if (bracketStart != -1 && bracketEnd != -1) {
                String name = line.substring(0, bracketStart).trim();
                String marksStr = line.substring(bracketStart + 1, bracketEnd).trim();
                String[] tokens = marksStr.split("[,\\s]+");
                int[] marks = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    marks[i] = Integer.parseInt(tokens[i].trim());
                }
                new Student(name, marks).printResultCard();
                processedAny = true;
            }
        }

        if (!processedAny) {
            new Student("Asha", new int[]{80, 90, 70}).printResultCard();
            new Student("Ravi", new int[]{60, 55, 50}).printResultCard();
        }
        scanner.close();
    }
}
