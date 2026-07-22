import java.util.PriorityQueue;

public class Scenario5_KthAdmissionCutoff {

    public static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] scores1 = {88, 92, 75, 96, 84, 91, 79, 85, 90, 83};
        int rank = 3;
        System.out.println(rank + "rd highest score (cutoff): " + findKthLargest(scores1, rank));

        int[] scores2 = {100, 99, 98, 97, 96};
        System.out.println("2nd highest: " + findKthLargest(scores2, 2));

        int[] scores3 = {50, 50, 50, 50};
        System.out.println("3rd highest: " + findKthLargest(scores3, 3));
    }
}
