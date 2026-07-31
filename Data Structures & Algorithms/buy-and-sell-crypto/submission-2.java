class Solution {
    public int maxProfit(int[] prices) {
        int bp = prices[0];
        int profit = 0;

        for (int num : prices) {
            profit = Math.max(profit, num - bp);
            bp = Math.min(bp, num);
        }

        return profit;
    }

    /*

        10  1   5   6   7   1

    */
}
