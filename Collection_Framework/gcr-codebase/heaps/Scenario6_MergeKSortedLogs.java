import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class LogEntry {
    int timestamp;
    String message;

    LogEntry(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public String toString() {
        return "[" + timestamp + "] " + message;
    }
}

public class Scenario6_MergeKSortedLogs {

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> sources.get(a[0]).get(a[1]).timestamp -
                       sources.get(b[0]).get(b[1]).timestamp
        );
        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0];
            int elemIdx = top[1];
            merged.add(sources.get(sourceIdx).get(elemIdx));
            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        List<LogEntry> server1 = new ArrayList<>();
        server1.add(new LogEntry(100, "Server1: started"));
        server1.add(new LogEntry(300, "Server1: processing"));
        server1.add(new LogEntry(500, "Server1: done"));

        List<LogEntry> server2 = new ArrayList<>();
        server2.add(new LogEntry(200, "Server2: init"));
        server2.add(new LogEntry(400, "Server2: running"));
        server2.add(new LogEntry(600, "Server2: shutdown"));

        List<LogEntry> server3 = new ArrayList<>();
        server3.add(new LogEntry(150, "Server3: boot"));
        server3.add(new LogEntry(350, "Server3: active"));

        List<List<LogEntry>> sources = new ArrayList<>();
        sources.add(server1);
        sources.add(server2);
        sources.add(server3);

        List<LogEntry> merged = mergeKSortedLogs(sources);
        System.out.println("Merged timeline:");
        for (LogEntry entry : merged) {
            System.out.println("  " + entry);
        }
    }
}
