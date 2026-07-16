import java.util.*;

public class BubbleSort_SportsMeet {

    public static int bubbleSortSwaps(int[] arr) {
        int n = arr.length, swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swaps;
    }

    public static void insertionSortSwaps(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static int[] top3(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int n = sorted.length;
        return new int[]{sorted[n - 1], sorted[n - 2], sorted[n - 3]};
    }

    public static void tracePasses(int[] arr) {
        System.out.println("Initial: " + Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        // Trace [64, 25, 12, 22, 11]
        int[] traceArr = {64, 25, 12, 22, 11};
        tracePasses(traceArr);

        // Sports meet with 50 athletes (simulated with random scores)
        Random rand = new Random(42);
        int[] scores = new int[50];
        for (int i = 0; i < 50; i++) scores[i] = rand.nextInt(100) + 1;

        int[] a1 = scores.clone();
        int swaps = bubbleSortSwaps(a1);
        System.out.println("Bubble Sort swaps: " + swaps);

        int[] a2 = scores.clone();
        insertionSortSwaps(a2);
        System.out.println("Insertion Sort done.");

        int[] medalists = top3(scores);
        System.out.println("Top 3 medalists: " + Arrays.toString(medalists));

        // Best case test
        int[] sorted = {11, 12, 22, 25, 64};
        int bestSwaps = bubbleSortSwaps(sorted);
        System.out.println("Best case swaps (already sorted): " + bestSwaps);
    }
}
