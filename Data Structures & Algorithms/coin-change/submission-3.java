class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] > i) { // skip coins larger than current amount
                    continue;
                }
                if (dp[i - coins[j]] > amount) { // skip unreachable coins
                    continue;
                }
                dp[i] = Math.min(
                    dp[i], 1 + dp[i - coins[j]]); // calculate for each amount with each coins
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
