import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array: ");
            int size = Integer.parseInt(scanner.nextLine());

            int[] arr = new int[size];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Enter the target sum: ");
            int target = Integer.parseInt(scanner.nextLine());

            findSubarrays(arr, target);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static void findSubarrays(int[] arr, int target) {
        int n = arr.length;
        boolean found = false;

        // Iterate through all possible subarrays
        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            for (int end = start; end < n; end++) {
                currentSum += arr[end];
                if (currentSum == target) {
                    printSubarray(arr, start, end);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No subarray found with the given sum");
        }
    }

    private static void printSubarray(int[] arr, int start, int end) {
        System.out.print("Subarray found from index " + start + " to " + end + ": ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
