class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        boolean[] dp = new boolean[l+1];
        dp[l] = true;

        for (int i = l - 1; i >= 0; i--) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (s.startsWith(wordDict.get(j), i)) {
                    if (i + wordDict.get(j).length() > l) {
                        continue;
                    }
                    if (dp[i + wordDict.get(j).length()]) {
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[0];
    }
}
