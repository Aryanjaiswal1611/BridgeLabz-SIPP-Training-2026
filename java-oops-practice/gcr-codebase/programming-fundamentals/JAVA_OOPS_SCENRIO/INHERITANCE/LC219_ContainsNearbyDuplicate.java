import java.util.*;

// LeetCode 219: Contains Duplicate II
// Sliding window + HashSet - O(n) time, O(k) space

public class LC219_ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) return true;
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LC219_ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); // true
        System.out.println(new LC219_ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)); // false
    }
}
