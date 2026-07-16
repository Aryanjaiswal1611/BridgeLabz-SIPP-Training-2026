import java.util.*;

public class BubbleSort_StudentMarks {
    public static void bubbleSort(int[] arr) {
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
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] marks = new int[N];
        for (int i = 0; i < N; i++) marks[i] = sc.nextInt();
        bubbleSort(marks);
        System.out.println(Arrays.toString(marks));
        sc.close();
    }
}
