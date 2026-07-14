import java.util.*;

public class VariableWindow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        HashMap<Character, Integer> target = new HashMap<>();

        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int required = target.size();
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (target.containsKey(ch) &&
                    window.get(ch).intValue() == target.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                window.put(remove, window.get(remove) - 1);

                if (target.containsKey(remove) &&
                        window.get(remove) < target.get(remove)) {
                    formed--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            System.out.println("");

        else
            System.out.println(s.substring(start, start + minLen));
    }
}