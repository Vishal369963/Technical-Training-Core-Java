import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        try {
            System.out.println("Enter numbers (type 'done' to finish):");
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
            scanner.next(); // Consume non-integer input to break the loop
            System.out.println(checkOddEven(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static String checkOddEven(List<Integer> numbers) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }

        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);
        boolean allOdd = numbers.stream().allMatch(num -> num % 2 != 0);

        if (allEven) {
            return "All numbers are even";
        } else if (allOdd) {
            return "All numbers are odd";
        } else {
            return "List contains both odd and even numbers";
        }
    }
}