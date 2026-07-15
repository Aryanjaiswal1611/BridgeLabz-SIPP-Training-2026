import java.util.*;

// LeetCode 146: LRU Cache (interface-based design)
// Design a data structure that follows the Least Recently Used (LRU) cache constraint

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public void display() {
        System.out.println("Cache: " + map);
    }
}

public class LC146_LRUCache {
    public static void main(String[] args) {
        System.out.println("=== LeetCode 146: LRU Cache ===\n");

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1) = " + cache.get(1));    // returns 1
        cache.put(3, 3);                                  // evicts key 2
        cache.display();
        System.out.println("get(2) = " + cache.get(2));    // returns -1
        cache.put(4, 4);                                  // evicts key 1
        cache.display();
        System.out.println("get(1) = " + cache.get(1));    // returns -1
        System.out.println("get(3) = " + cache.get(3));    // returns 3
        System.out.println("get(4) = " + cache.get(4));    // returns 4
    }
}
