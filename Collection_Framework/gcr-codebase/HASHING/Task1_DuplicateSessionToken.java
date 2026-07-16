import java.util.HashSet;
import java.util.Set;

public class Task1_DuplicateSessionToken {

    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens1 = {"abc123", "def456", "ghi789", "abc123"};
        System.out.println("Test 1 (has duplicate): " + hasDuplicateToken(tokens1)); // true

        String[] tokens2 = {"abc123", "def456", "ghi789"};
        System.out.println("Test 2 (no duplicate): " + hasDuplicateToken(tokens2)); // false

        String[] tokens3 = {};
        System.out.println("Test 3 (empty): " + hasDuplicateToken(tokens3)); // false

        String[] tokens4 = {"token"};
        System.out.println("Test 4 (single): " + hasDuplicateToken(tokens4)); // false

        String[] tokens5 = {"a", "b", "c", "b", "a"};
        System.out.println("Test 5 (multiple duplicates): " + hasDuplicateToken(tokens5)); // true
    }
}
