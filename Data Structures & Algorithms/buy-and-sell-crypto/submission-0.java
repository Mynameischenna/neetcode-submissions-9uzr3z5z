class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, bought = prices[0];
        for (int i = 0; i < prices.length;i ++) {
            if (prices[i] - bought > maxProfit) maxProfit = prices[i] - bought;
            if (prices[i] < bought) bought = prices[i];
        }
        return maxProfit;
    }
}
