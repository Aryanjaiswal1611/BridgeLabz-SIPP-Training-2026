import java.util.*;

public class Scenario1_SparseFriendGraph {

    private final Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    public static void main(String[] args) {
        Scenario1_SparseFriendGraph social = new Scenario1_SparseFriendGraph();

        social.addFriendship(1, 2);
        social.addFriendship(1, 3);
        social.addFriendship(2, 4);
        social.addFriendship(5, 6);

        System.out.println("isFriend(1, 2): " + social.isFriend(1, 2));
        System.out.println("isFriend(1, 4): " + social.isFriend(1, 4));
        System.out.println("isFriend(5, 6): " + social.isFriend(5, 6));
        System.out.println("isFriend(3, 4): " + social.isFriend(3, 4));
    }
}
