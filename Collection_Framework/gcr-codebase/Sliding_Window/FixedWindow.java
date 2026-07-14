import java.util.*;

public class FixedWindow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        if (k > n) {
            System.out.println("Invalid Window Size");
            return;
        }

        // Calculate sum of first window
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {

            windowSum += arr[i];       // Add new element
            windowSum -= arr[i - k];   // Remove old element

            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Maximum Window Sum = " + maxSum);

        sc.close();
    }
}