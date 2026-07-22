import java.util.*;

public class GraphScenario4_NetworkSegments {

    public static int countNetworkSegments(Map<Integer, List<Integer>> network, int n) {
        Set<Integer> visited = new HashSet<>();
        int segments = 0;
        for (int server = 0; server < n; server++) {
            if (!visited.contains(server)) {
                segments++;
                dfsMark(network, server, visited);
            }
        }
        return segments;
    }

    private static void dfsMark(Map<Integer, List<Integer>> network, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : network.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsMark(network, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> network1 = new HashMap<>();
        network1.put(0, Arrays.asList(1));
        network1.put(1, Arrays.asList(0, 2));
        network1.put(2, Arrays.asList(1));
        network1.put(3, Arrays.asList(4));
        network1.put(4, Arrays.asList(3));

        int segments1 = countNetworkSegments(network1, 5);
        System.out.println("Network 1 segments: " + segments1);
        System.out.println("Fully connected: " + (segments1 == 1));

        Map<Integer, List<Integer>> network2 = new HashMap<>();
        network2.put(0, Arrays.asList(1));
        network2.put(1, Arrays.asList(0, 2));
        network2.put(2, Arrays.asList(1));

        int segments2 = countNetworkSegments(network2, 3);
        System.out.println("Network 2 segments: " + segments2);
        System.out.println("Fully connected: " + (segments2 == 1));
    }
}
