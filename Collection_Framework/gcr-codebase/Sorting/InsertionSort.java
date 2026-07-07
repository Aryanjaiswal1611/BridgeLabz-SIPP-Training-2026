import java.util.Scanner;

public class InsertionSortEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] id = new int[n];

        System.out.println("Enter Employee IDs:");

        for (int i = 0; i < n; i++) {
            id[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int key = id[i];
            int j = i - 1;

            while (j >= 0 && id[j] > key) {
                id[j + 1] = id[j];
                j--;
            }

            id[j + 1] = key;
        }

        System.out.println("Sorted Employee IDs:");

        for (int x : id) {
            System.out.print(x + " ");
        }
    }
}