class Solution {
    Integer[] memo;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        this.n = cost.length;
        memo = new Integer[n];
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    public int dfs(int i, int[] cost) {
        if (i >= n) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(dfs(i + 1, cost), dfs(i + 2, cost));
        return memo[i];
    }
}
