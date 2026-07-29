class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            dp[i] = dp[i + 1];
            if (i < n - 1) {
                int tens = s.charAt(i) - '0';
                int ones = s.charAt(i + 1) - '0';
                int num = tens * 10 + ones;

                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
