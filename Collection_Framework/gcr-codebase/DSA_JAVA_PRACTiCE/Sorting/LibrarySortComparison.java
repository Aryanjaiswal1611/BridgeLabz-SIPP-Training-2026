import java.util.*;

public class LibrarySortComparison {

    // ---------- Merge Sort ----------
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
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

    // ---------- Quick Sort (3-way Lomuto) ----------
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int[] p = threeWayPartition(arr, low, high);
            quickSort(arr, low, p[0] - 1);
            quickSort(arr, p[1] + 1, high);
        }
    }

    private static int[] threeWayPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int lt = low, gt = high, i = low;
        while (i <= gt) {
            if (arr[i] < pivot) swap(arr, lt++, i++);
            else if (arr[i] > pivot) swap(arr, i, gt--);
            else i++;
        }
        return new int[]{lt, gt};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // ---------- Counting Sort ----------
    public static void countingSort(int[] arr, int maxVal) {
        int[] count = new int[maxVal + 1];
        for (int v : arr) count[v]++;
        int idx = 0;
        for (int i = 1; i <= maxVal; i++) {
            while (count[i]-- > 0) arr[idx++] = i;
        }
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random rand = new Random(42);

        System.out.println("Library Sorting Benchmark (genre codes 1-20)");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s%n", "Size", "Merge Sort (ns)", "Quick Sort (ns)", "Counting Sort (ns)");
        System.out.println("--------------------------------------------------");

        for (int size : sizes) {
            int[] base = new int[size];
            for (int i = 0; i < size; i++) base[i] = rand.nextInt(20) + 1;

            int[] arr1 = base.clone();
            long t1 = System.nanoTime();
            mergeSort(arr1, 0, arr1.length - 1);
            long t2 = System.nanoTime();
            long mergeTime = t2 - t1;

            int[] arr2 = base.clone();
            t1 = System.nanoTime();
            quickSort(arr2, 0, arr2.length - 1);
            t2 = System.nanoTime();
            long quickTime = t2 - t1;

            int[] arr3 = base.clone();
            t1 = System.nanoTime();
            countingSort(arr3, 20);
            t2 = System.nanoTime();
            long countingTime = t2 - t1;

            System.out.printf("%-10d %-20d %-20d %-20d%n", size, mergeTime, quickTime, countingTime);
        }
    }
}
