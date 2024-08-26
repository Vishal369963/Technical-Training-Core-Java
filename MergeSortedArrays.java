import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the first array: ");
            int size1 = Integer.parseInt(scanner.nextLine());

            int[] arr1 = new int[size1];
            System.out.println("Enter the elements of the first array in sorted order:");
            for (int i = 0; i < size1; i++) {
                arr1[i] = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Enter the size of the second array: ");
            int size2 = Integer.parseInt(scanner.nextLine());

            int[] arr2 = new int[size2];
            System.out.println("Enter the elements of the second array in sorted order:");
            for (int i = 0; i < size2; i++) {
                arr2[i] = Integer.parseInt(scanner.nextLine());
            }

            mergeSortedArrays(arr1, arr2);
            System.out.println("First array after merging:");
            for (int i : arr1) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("Second array after merging:");
            for (int i : arr2) {
                System.out.print(i + " ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        for (int i = m - 1; i >= 0; i--) {
            int j, last = arr1[n - 1];
            for (j = n - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }

            if (j != n - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
