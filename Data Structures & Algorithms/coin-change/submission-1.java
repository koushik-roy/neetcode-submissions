class Solution {
    int[] coins;
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dfs(amount) >amount ? -1 : dfs(amount);
    }

    public int dfs(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int answer = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (dfs(amount - coin) == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.min(answer, 1 + dfs(amount - coin));
        }

        map.put(amount, answer);
        return answer;
    }
}
