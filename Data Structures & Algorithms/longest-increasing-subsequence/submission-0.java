class Solution {
    Integer[][] memo;
    int[] nums;
    // int count = 0;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.memo = new Integer[nums.length][nums.length+1];
        return dfs(0, -1);
    }

    public int dfs(int i, int j) {
        if (i >= nums.length)
            return 0;
        if (memo[i][j+1] != null)
            return memo[i][j+1];
        int include = 0, exclude = 0;
        exclude = dfs(i + 1, j);
        if (j == -1 || nums[i] > nums[j]) {
            include = 1 + dfs(i + 1, i);
        }

        int ans = Math.max(include, exclude);
        memo[i][j+1] = ans;
        return ans;
    }
}
