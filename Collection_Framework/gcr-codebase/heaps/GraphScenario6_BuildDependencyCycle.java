import java.util.*;

public class GraphScenario6_BuildDependencyCycle {

    public static boolean hasCircularDependency(Map<Integer, List<Integer>> tasks, int n) {
        int[] state = new int[n];
        for (int v = 0; v < n; v++) {
            if (state[v] == 0) {
                if (dfsCycleCheck(tasks, v, state)) return true;
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> tasks, int node, int[] state) {
        state[node] = 1;
        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {
            if (state[dep] == 1) return true;
            if (state[dep] == 0 && dfsCycleCheck(tasks, dep, state)) return true;
        }
        state[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> tasks1 = new HashMap<>();
        tasks1.put(0, Arrays.asList(1));
        tasks1.put(1, Arrays.asList(2));
        tasks1.put(2, Arrays.asList(3));
        tasks1.put(3, new ArrayList<>());
        System.out.println("Tasks 1 has cycle: " + hasCircularDependency(tasks1, 4));

        Map<Integer, List<Integer>> tasks2 = new HashMap<>();
        tasks2.put(0, Arrays.asList(1));
        tasks2.put(1, Arrays.asList(2));
        tasks2.put(2, Arrays.asList(0));
        System.out.println("Tasks 2 has cycle: " + hasCircularDependency(tasks2, 3));

        Map<Integer, List<Integer>> tasks3 = new HashMap<>();
        tasks3.put(0, Arrays.asList(1, 2));
        tasks3.put(1, Arrays.asList(3));
        tasks3.put(2, Arrays.asList(3));
        tasks3.put(3, new ArrayList<>());
        System.out.println("Tasks 3 (diamond) has cycle: " + hasCircularDependency(tasks3, 4));
    }
}
