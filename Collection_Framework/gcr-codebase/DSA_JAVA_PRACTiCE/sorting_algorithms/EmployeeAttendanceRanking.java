import java.util.*;

public class EmployeeAttendanceRanking {

    static class Employee {
        int id;
        int attendance;
        Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }
    }

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int K) {
        int n = employeeIds.length;
        Employee[] emp = new Employee[n];
        for (int i = 0; i < n; i++) {
            emp[i] = new Employee(employeeIds[i], attendance[i]);
        }

        Arrays.sort(emp, (a, b) -> {
            if (b.attendance != a.attendance) return b.attendance - a.attendance;
            return a.id - b.id;
        });

        int[] result = new int[K];
        for (int i = 0; i < K; i++) result[i] = emp[i].id;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ids = new int[N];
        int[] att = new int[N];
        for (int i = 0; i < N; i++) ids[i] = sc.nextInt();
        for (int i = 0; i < N; i++) att[i] = sc.nextInt();
        int K = sc.nextInt();
        int[] top = topKEmployees(ids, att, K);
        System.out.println(Arrays.toString(top));
        sc.close();
    }
}
