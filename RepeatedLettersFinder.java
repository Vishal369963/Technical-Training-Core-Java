import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class RepeatedLettersFinder {

    
    public static void printRepeatedLetters(String str) throws IllegalArgumentException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) { // Consider only letters
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }

        
        boolean found = false;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No repeated letters found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            
            
            printRepeatedLetters(input);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
