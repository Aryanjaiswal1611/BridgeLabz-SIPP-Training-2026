import java.util.*;

public class QuickSort_FlightTicketPrices {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int[] p = threeWayPartition(arr, low, high);
            quickSort(arr, low, p[0] - 1);
            quickSort(arr, p[1] + 1, high);
        }
    }

    public static int[] threeWayPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int lt = low, gt = high, i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        return new int[]{lt, gt};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) prices[i] = sc.nextInt();
        quickSort(prices, 0, N - 1);
        System.out.println(Arrays.toString(prices));
        sc.close();
    }
}
