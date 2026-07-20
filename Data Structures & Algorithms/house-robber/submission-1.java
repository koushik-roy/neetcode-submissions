class Solution {
    int[] nums; Integer[] memo;
    public int rob(int[] nums) {
        this.nums = nums;
        this.memo=new Integer[nums.length];
        return Math.max(dfs(0), dfs(1));
    }

    public int dfs(int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] = Math.max(nums[i] + dfs(i + 2), dfs(i + 1));
        return memo[i];
    }
}
