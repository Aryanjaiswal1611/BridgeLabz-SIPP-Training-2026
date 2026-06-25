// LeetCode 338: Counting Bits
// DP: for i, number of 1 bits = bits[i >> 1] + (i & 1)

public class LC338_CountingBits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println("=== LeetCode 338: Counting Bits ===\n");

        LC338_CountingBits sol = new LC338_CountingBits();
        int[] res = sol.countBits(5);
        System.out.print("n=5: ");
        for (int x : res) System.out.print(x + " ");
        System.out.println();

        res = sol.countBits(10);
        System.out.print("n=10: ");
        for (int x : res) System.out.print(x + " ");
        System.out.println();

        // Verify: 0->0, 1->1, 2->1, 3->2, 4->1, 5->2
        res = sol.countBits(2);
        System.out.print("n=2: ");
        for (int x : res) System.out.print(x + " ");
        System.out.println();
    }
}
