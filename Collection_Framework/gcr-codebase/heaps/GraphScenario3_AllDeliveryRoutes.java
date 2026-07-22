import java.util.*;

public class GraphScenario3_AllDeliveryRoutes {

    public static List<List<Integer>> allRoutes(Map<Integer, List<Integer>> roads, int origin, int target) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(roads, origin, target, path, visited, allRoutes);
        return allRoutes;
    }

    private static void dfs(Map<Integer, List<Integer>> roads, int current, int target,
                            List<Integer> path, Set<Integer> visited,
                            List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    dfs(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = new HashMap<>();
        roads.put(1, Arrays.asList(2, 3));
        roads.put(2, Arrays.asList(1, 4, 5));
        roads.put(3, Arrays.asList(1, 5));
        roads.put(4, Arrays.asList(2, 6));
        roads.put(5, Arrays.asList(2, 3, 6));
        roads.put(6, Arrays.asList(4, 5));

        List<List<Integer>> routes = allRoutes(roads, 1, 6);
        System.out.println("All routes from 1 to 6:");
        for (List<Integer> route : routes) {
            System.out.println("  " + route);
        }
        System.out.println("Total distinct routes: " + routes.size());
    }
}
