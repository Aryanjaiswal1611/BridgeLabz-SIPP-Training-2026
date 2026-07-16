import java.util.HashMap;
import java.util.Map;

public class Task2_MostFrequentErrorCode {

    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0], bestCount = 0;
        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }
        return bestCode;
    }

    public static void main(String[] args) {
        int[] codes1 = {1, 2, 3, 2, 2, 4, 1, 2};
        System.out.println("Test 1: " + mostFrequentErrorCode(codes1)); // 2

        int[] codes2 = {500, 500, 400, 300, 400, 500};
        System.out.println("Test 2: " + mostFrequentErrorCode(codes2)); // 500

        int[] codes3 = {10};
        System.out.println("Test 3: " + mostFrequentErrorCode(codes3)); // 10

        int[] codes4 = {404, 500, 404, 500, 404};
        System.out.println("Test 4: " + mostFrequentErrorCode(codes4)); // 404

        int[] codes5 = {1, 1, 2, 2, 3};
        System.out.println("Test 5 (first max): " + mostFrequentErrorCode(codes5)); // 1 or 2 (whichever hits max first)
    }
}
