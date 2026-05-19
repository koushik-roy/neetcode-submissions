class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, maxProfit = 0;

        for (int j = 1; j < prices.length; j++) {
            if (prices[i] > prices[j]) {
                i = j;
            }
            int profit = prices[j] - prices[i];
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
