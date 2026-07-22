import java.util.*;

public class GraphScenario5_CircuitCycleDetection {

    public static boolean hasWiringLoop(Map<Integer, List<Integer>> circuit, int n) {
        Set<Integer> visited = new HashSet<>();
        for (int v = 0; v < n; v++) {
            if (!visited.contains(v)) {
                if (dfsCycleCheck(circuit, v, -1, visited)) return true;
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> circuit, int node, int parent,
                                         Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : circuit.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (dfsCycleCheck(circuit, neighbor, node, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> circuit1 = new HashMap<>();
        circuit1.put(0, Arrays.asList(1));
        circuit1.put(1, Arrays.asList(0, 2));
        circuit1.put(2, Arrays.asList(1, 3));
        circuit1.put(3, Arrays.asList(2));
        System.out.println("Circuit 1 has loop: " + hasWiringLoop(circuit1, 4));

        Map<Integer, List<Integer>> circuit2 = new HashMap<>();
        circuit2.put(0, Arrays.asList(1));
        circuit2.put(1, Arrays.asList(0, 2));
        circuit2.put(2, Arrays.asList(1, 0));
        System.out.println("Circuit 2 has loop: " + hasWiringLoop(circuit2, 3));

        Map<Integer, List<Integer>> circuit3 = new HashMap<>();
        circuit3.put(0, Arrays.asList(1));
        circuit3.put(1, Arrays.asList(0, 2));
        circuit3.put(2, Arrays.asList(1, 3));
        circuit3.put(3, Arrays.asList(2, 0));
        System.out.println("Circuit 3 has loop: " + hasWiringLoop(circuit3, 4));
    }
}
