// LeetCode 343: Integer Break
// Break n into k positive integers summing to n, maximize their product.
// Math: use as many 3's as possible (3*3 > 2*2*2)

public class LC343_IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }

    public static void main(String[] args) {
        System.out.println("=== LeetCode 343: Integer Break ===\n");

        LC343_IntegerBreak sol = new LC343_IntegerBreak();
        System.out.println("n=2 -> " + sol.integerBreak(2) + " (expected 1)");
        System.out.println("n=3 -> " + sol.integerBreak(3) + " (expected 2)");
        System.out.println("n=4 -> " + sol.integerBreak(4) + " (expected 4)");
        System.out.println("n=5 -> " + sol.integerBreak(5) + " (expected 6)");
        System.out.println("n=10 -> " + sol.integerBreak(10) + " (expected 36)");
    }
}
