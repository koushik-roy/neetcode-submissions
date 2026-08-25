class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        int i = 1;
        while (i < prices.length) {
            minPrice = Math.min(minPrice, prices[i]);

            maxProfit = Math.max(prices[i]-minPrice, maxProfit);
            i++;
        }

        return maxProfit;
    }
}