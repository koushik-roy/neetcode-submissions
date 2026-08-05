class Solution {
    Boolean[] memo;
    List<String> dict;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict = wordDict;
        this.s = s;
        memo = new Boolean[s.length()];
        // Arrays.fill(memo, false);
        return dfs(0);
    }

    public boolean dfs(int index) {
        if (index > s.length()) {
            return false;
        }
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        // index=string iterator, i=dict list iterator

        for (int i = 0; i < dict.size(); i++) {
            String currWord = dict.get(i);
            if (s.startsWith(currWord, index)) {
                if (dfs(index + currWord.length())) {
                    memo[index] = true;
                    return true;
                }
            }
        }
        memo[index] = false;
        return false;
    }
}
