import java.util.Arrays;

public class Scenario3_HeapSortSensorReadings {

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }
        for (int end = n - 1; end > 0; end--) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            siftDownMax(arr, 0, end);
        }
    }

    private static void siftDownMax(int[] arr, int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            siftDownMax(arr, largest, size);
        }
    }

    public static void main(String[] args) {
        int[] readings1 = {23, 17, 42, 8, 31, 15, 29};
        System.out.println("Before sort: " + Arrays.toString(readings1));
        heapSort(readings1);
        System.out.println("After sort:  " + Arrays.toString(readings1));

        int[] readings2 = {5, 4, 3, 2, 1};
        System.out.println("Before sort: " + Arrays.toString(readings2));
        heapSort(readings2);
        System.out.println("After sort:  " + Arrays.toString(readings2));
    }
}
