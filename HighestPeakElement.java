import java.util.Scanner;

public class HighestPeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of elements in the array: ");
            int n = Integer.parseInt(scanner.nextLine());

            if (n <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }

            int[] array = new int[n];
            System.out.println("Enter the array elements:");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(scanner.nextLine());
            }

            findHighestPeakElement(array);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static void findHighestPeakElement(int[] array) {
        if (array.length < 1) {
            System.out.println("Array is empty.");
            return;
        } else if (array.length == 1) {
            System.out.println("The only element in the array is: " + array[0]);
            return;
        } else if (array.length == 2) {
            if (array[0] == array[1]) {
                System.out.println("No peak element found.");
            } else {
                int val = Math.max(array[0], array[1]);
                System.out.println("The highest element in the array is: " + val);
            }
            return;
        }

        int highestPeak = Integer.MIN_VALUE;
        int peakIndex = -1;

        // Check if the first element is a peak
        if (array[0] > array[1]) {
            highestPeak = array[0];
            peakIndex = 0;
        }

        // Check if the last element is a peak
        if (array[array.length - 1] > array[array.length - 2]) {
            if (array[array.length - 1] > highestPeak) {
                highestPeak = array[array.length - 1];
                peakIndex = array.length - 1;
            }
        }

        // Iterate through the array to find peaks between the first and last element
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                if (array[i] > highestPeak) {
                    highestPeak = array[i];
                    peakIndex = i;
                }
            }
        }

        if (peakIndex != -1) {
            System.out.println("The highest element greater than its neighbors is at index: " + peakIndex + " and the element is " + highestPeak);
        } else {
            System.out.println("No peak element found.");
        }
    }
}
