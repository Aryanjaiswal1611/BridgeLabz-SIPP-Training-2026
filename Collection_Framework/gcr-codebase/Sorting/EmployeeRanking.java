import java.util.Scanner;

public class EmployeeRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] id = new int[n];
        int[] attendance = new int[n];

        System.out.println("Enter Employee IDs:");
        for (int i = 0; i < n; i++) {
            id[i] = sc.nextInt();
        }

        System.out.println("Enter Attendance:");
        for (int i = 0; i < n; i++) {
            attendance[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int max = i;

            for (int j = i + 1; j < n; j++) {
                if (attendance[j] > attendance[max]) {
                    max = j;
                } else if (attendance[j] == attendance[max] && id[j] < id[max]) {
                    max = j;
                }
            }

            int temp = attendance[i];
            attendance[i] = attendance[max];
            attendance[max] = temp;

            temp = id[i];
            id[i] = id[max];
            id[max] = temp;
        }

        System.out.println("Top " + k + " Employees:");

        for (int i = 0; i < k; i++) {
            System.out.print(id[i] + " ");
        }
    }
}