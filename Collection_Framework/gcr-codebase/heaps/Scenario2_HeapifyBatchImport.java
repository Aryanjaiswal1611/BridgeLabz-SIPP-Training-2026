import java.util.Arrays;

public class Scenario2_HeapifyBatchImport {

    public static void buildMinHeap(int[] priorities) {
        int n = priorities.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    private static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] < arr[smallest]) smallest = left;
        if (right < size && arr[right] < arr[smallest]) smallest = right;
        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            siftDown(arr, smallest, size);
        }
    }

    public static void main(String[] args) {
        int[] priorities1 = {4, 10, 3, 5, 1, 7, 9};
        System.out.println("Before heapify: " + Arrays.toString(priorities1));
        buildMinHeap(priorities1);
        System.out.println("After heapify:  " + Arrays.toString(priorities1));

        int[] priorities2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Before heapify: " + Arrays.toString(priorities2));
        buildMinHeap(priorities2);
        System.out.println("After heapify:  " + Arrays.toString(priorities2));
    }
}
