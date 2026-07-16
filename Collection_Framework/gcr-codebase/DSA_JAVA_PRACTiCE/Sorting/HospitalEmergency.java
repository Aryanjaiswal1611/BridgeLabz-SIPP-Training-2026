import java.util.*;

public class HospitalEmergency {

    public static int findKthHighest(int[] priorities, int k) {
        return quickSelect(priorities, 0, priorities.length - 1, priorities.length - k);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];
        int pivotIndex = lomutoPartition(arr, low, high);
        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return quickSelect(arr, low, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, high, k);
    }

    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] priorities = new int[N];
        for (int i = 0; i < N; i++) priorities[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findKthHighest(priorities, k));
        sc.close();
    }
}
