

import java.util.Scanner;

interface SwapInterface {
    int[] swap(int a, int b);
}

class SwapWithTemp implements SwapInterface {
    @Override
    public int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }
}

class SwapWithoutTemp implements SwapInterface {
    @Override
    public int[] swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }
}

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            int num1 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter the second number: ");
            int num2 = Integer.parseInt(scanner.nextLine());

            SwapInterface swapWithTemp = new SwapWithTemp();
            SwapInterface swapWithoutTemp = new SwapWithoutTemp();

            int[] resultWithTemp = swapWithTemp.swap(num1, num2);
            int[] resultWithoutTemp = swapWithoutTemp.swap(num1, num2);

            System.out.println("Swapped with temp variable: " + resultWithTemp[0] + ", " + resultWithTemp[1]);
            System.out.println("Swapped without temp variable: " + resultWithoutTemp[0] + ", " + resultWithoutTemp[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }

        scanner.close();
    }
}