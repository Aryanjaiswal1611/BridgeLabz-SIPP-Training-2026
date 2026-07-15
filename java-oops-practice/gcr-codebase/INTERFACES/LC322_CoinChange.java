import java.util.Arrays;

// LeetCode 322: Coin Change
// DP - bottom up: min coins to make amount

public class LC322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("=== LeetCode 322: Coin Change ===\n");

        LC322_CoinChange sol = new LC322_CoinChange();
        System.out.println("coins=[1,2,5], amount=11 -> " + sol.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println("coins=[2], amount=3 -> " + sol.coinChange(new int[]{2}, 3));             // -1
        System.out.println("coins=[1], amount=0 -> " + sol.coinChange(new int[]{1}, 0));             // 0
        System.out.println("coins=[186,419,83,408], amount=6249 -> " + sol.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
