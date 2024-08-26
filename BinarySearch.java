import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array: ");
            int size = Integer.parseInt(scanner.nextLine());

            int[] arr = new int[size];
            System.out.println("Enter the elements of the array in sorted order:");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Enter the target element: ");
            int target = Integer.parseInt(scanner.nextLine());

            int result = binarySearch(arr, target);
            if (result == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element found at index: " + result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}