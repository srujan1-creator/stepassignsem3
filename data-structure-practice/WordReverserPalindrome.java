import java.util.Scanner;

/**
 * STEP SEM-3 · CodInClub | Powered by BridgeLabz
 * CATEGORY C - Data Structure Practice
 * Problem 2: Word Reverser and Palindrome Checker
 *
 * Task:
 * Create a program that reads a word, reverses it using a mutable text builder
 * (like StringBuilder in Java), and then prints the reversed word. Additionally,
 * determine and print whether the original word reads the same forwards and
 * backwards (is a palindrome).
 *
 * Example:
 * Input:
 * level
 * java
 * Output:
 * level - palindrome
 * avaj - not a palindrome
 */
public class WordReverserPalindrome {

    public static void processWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        if (isPalindrome) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                processWord(word);
            }
        } else {
            processWord("level");
            processWord("java");
        }
        scanner.close();
    }
}
