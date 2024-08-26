import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first string: ");
            String str1 = scanner.nextLine();

            System.out.print("Enter the second string: ");
            String str2 = scanner.nextLine();

            System.out.println("Are anagrams: " + areAnagrams(str1, str2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) throws Exception {
        if (str1 == null || str2 == null) {
            throw new Exception("Inputs must be non-null strings");
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
