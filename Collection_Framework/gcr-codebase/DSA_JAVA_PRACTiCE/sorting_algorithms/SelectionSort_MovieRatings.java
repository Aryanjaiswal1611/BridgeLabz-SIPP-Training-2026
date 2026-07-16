import java.util.*;

public class SelectionSort_MovieRatings {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ratings = new int[N];
        for (int i = 0; i < N; i++) ratings[i] = sc.nextInt();
        selectionSort(ratings);
        System.out.println(Arrays.toString(ratings));
        sc.close();
    }
}
