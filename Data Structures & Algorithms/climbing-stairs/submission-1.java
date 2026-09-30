class Solution {
    Integer[] memo;

    public int climbStairs(int n) {
        this.memo = new Integer[n];
        return dfs(0, n);
    }

    public int dfs(int i, int n) {
        if (i == n) {
            return 1;
        }
        if (i > n) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        memo[i] = dfs(i + 1, n) + dfs(i + 2, n);

        return memo[i];
    }
}