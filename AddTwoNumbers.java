import java.util.InputMismatchException;
import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        double num1 = 0;
        double num2 = 0;

        
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();

                validInput = true; 

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); 
            }
        }

        
        double sum = num1 + num2;

        
        System.out.printf("The sum of %.2f and %.2f is %.2f%n", num1, num2, sum);

        scanner.close();
    }
}
