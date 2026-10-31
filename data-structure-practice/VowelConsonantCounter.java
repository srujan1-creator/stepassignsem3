import java.util.Locale;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 1: Vowel and Consonant Counter
 *
 * Task:
 * Write a program that reads a single word and then counts and prints the total
 * number of vowels and consonants in that word. Assume the input word contains
 * only alphabetic characters (case-insensitive).
 *
 * Example:
 * Input: Programming
 * Output:
 * Vowels: 3
 * Consonants: 8
 */
public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String word) {
        if (word == null || word.isEmpty()) {
            System.out.println("Vowels: 0");
            System.out.println("Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;
        String lower = word.toLowerCase(Locale.US);

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String word = scanner.next();
            countVowelsAndConsonants(word);
        } else {
            // Default sample demo
            countVowelsAndConsonants("Programming");
        }
        scanner.close();
    }
}
