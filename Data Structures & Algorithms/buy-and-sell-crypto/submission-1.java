class Solution {
    public int maxProfit(int[] prices) {
        int bp = prices[0];
        int n = prices.length;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, prices[i] - bp);
            bp = Math.min(bp, prices[i]);
        }

        return ans;
    }
}
