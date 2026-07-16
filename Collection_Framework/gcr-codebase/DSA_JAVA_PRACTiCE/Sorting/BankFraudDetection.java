import java.util.*;

public class BankFraudDetection {
    private static long suspiciousCount = 0;

    public static long countSuspiciousPairs(int[] amounts) {
        suspiciousCount = 0;
        mergeSort(amounts, 0, amounts.length - 1);
        return suspiciousCount;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            countWhileMerging(arr, left, mid, right);
            merge(arr, left, mid, right);
        }
    }

    private static void countWhileMerging(int[] arr, int left, int mid, int right) {
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) arr[i] > 3L * arr[j]) j++;
            suspiciousCount += (j - (mid + 1));
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] amounts = new int[N];
        for (int i = 0; i < N; i++) amounts[i] = sc.nextInt();
        System.out.println(countSuspiciousPairs(amounts));
        sc.close();
    }
}
