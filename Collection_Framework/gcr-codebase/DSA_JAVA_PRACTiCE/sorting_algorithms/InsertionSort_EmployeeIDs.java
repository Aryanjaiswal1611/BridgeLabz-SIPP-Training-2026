import java.util.*;

public class InsertionSort_EmployeeIDs {
    public static void insertionSort(int[] arr) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ids = new int[N];
        for (int i = 0; i < N; i++) ids[i] = sc.nextInt();
        insertionSort(ids);
        System.out.println(Arrays.toString(ids));
        sc.close();
    }
}
