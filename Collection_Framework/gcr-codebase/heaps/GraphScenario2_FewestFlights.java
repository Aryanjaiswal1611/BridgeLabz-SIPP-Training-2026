import java.util.*;

public class GraphScenario2_FewestFlights {

    public static List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (city == destination) break;
            for (int next : routes.getOrDefault(city, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) return Collections.emptyList();

        LinkedList<Integer> path = new LinkedList<>();
        Integer node = destination;
        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }
        return path;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(0, Arrays.asList(1, 2));
        routes.put(1, Arrays.asList(0, 3, 4));
        routes.put(2, Arrays.asList(0, 5));
        routes.put(3, Arrays.asList(1, 6));
        routes.put(4, Arrays.asList(1));
        routes.put(5, Arrays.asList(2));
        routes.put(6, Arrays.asList(3));

        System.out.println("Path 0 -> 6: " + fewestFlights(routes, 0, 6));
        System.out.println("Path 0 -> 4: " + fewestFlights(routes, 0, 4));
        System.out.println("Path 0 -> 7: " + fewestFlights(routes, 0, 7));
    }
}
