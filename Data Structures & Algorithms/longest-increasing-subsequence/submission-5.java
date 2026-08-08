class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[][] dp = new int[l + 1][l + 1]; // dp[currIdx][prevIdx]
        // dp[6][*] = 0;
        // int in = 0, ex = 0;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int ex = dp[i + 1][j + 1];
                int in = 0;
                if (j == -1 || nums[i] > nums[j]) {
                    in = 1 + dp[i + 1][i + 1];
                }

                dp[i][j + 1] = Math.max(ex, in);
            }
        }

        return dp[0][0];
    }
}
