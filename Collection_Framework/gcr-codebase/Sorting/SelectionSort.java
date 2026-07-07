import java.util.Scanner;

public class SelectionSortExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] score = new int[n];

        System.out.println("Enter scores:");

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (score[j] < score[min]) {
                    min = j;
                }
            }

            int temp = score[i];
            score[i] = score[min];
            score[min] = temp;
        }

        System.out.println("Sorted Scores:");

        for (int x : score) {
            System.out.print(x + " ");
        }
    }
}