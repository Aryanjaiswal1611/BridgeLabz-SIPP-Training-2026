import java.util.*;

public class MergeCustomerRecords {

    public static int[] mergeSorted(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (A[i] <= B[j]) result[k++] = A[i++];
            else result[k++] = B[j++];
        }
        while (i < n) result[k++] = A[i++];
        while (j < m) result[k++] = B[j++];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) B[i] = sc.nextInt();
        int[] merged = mergeSorted(A, B);
        System.out.println(Arrays.toString(merged));
        sc.close();
    }
}
