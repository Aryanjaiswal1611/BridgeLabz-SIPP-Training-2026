import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Scenario4_TopKCustomers {

    public static List<Integer> topKSpending(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] transactions1 = {150, 320, 90, 510, 200, 780, 45, 640, 300};
        System.out.println("Top 3 spenders: " + topKSpending(transactions1, 3));

        int[] transactions2 = {100, 200, 300, 400, 500};
        System.out.println("Top 2 spenders: " + topKSpending(transactions2, 2));

        int[] transactions3 = {50, 30, 20, 10};
        System.out.println("Top 5 spenders (all): " + topKSpending(transactions3, 5));
    }
}
