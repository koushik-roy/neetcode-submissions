class Solution {
    int ways = 0;
    Integer[] memo;
    public int numDecodings(String s) {
        memo = new Integer[s.length() + 1];
        return dfs(s, 0);
    }

    public int dfs(String s, int i) {
        
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        ways = dfs(s, i + 1);

        if (i + 1 < s.length()) {
            int ones = s.charAt(i + 1) - '0';
            int tens = s.charAt(i) - '0';
            int nums = tens * 10 + ones;
            if (nums >= 10 && nums <= 26) {
                ways += dfs(s, i + 2);
            }
        }
        memo[i] = ways;
        return ways;
    }
}
