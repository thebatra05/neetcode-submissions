class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int maxProfit(int[] prices) {
        int n = prices.length;
        boolean buying = true;
        return dfs(prices, 0, buying);
    }

    int dfs(int[] prices, int idx, boolean buying) {
        if (idx >= prices.length) return 0;

        String key = idx + "-" + buying;
        if (memo.containsKey(key)) return memo.get(key);

        int profit = 0;
        if (buying) {
            profit = dfs(prices, idx + 1, false) - prices[idx];
            profit = Math.max(profit, dfs(prices, idx + 1, true));
        } 
        else {
            profit = dfs(prices, idx + 2, true) + prices[idx];
            profit = Math.max(profit, dfs(prices, idx + 1, false));
        }

        memo.put(key, profit);

        return profit;
    }

    

    /*
        0   1   2   3   4
        1   3   4   0   4
    dfs(prices, 0, true)    
        dfs(prices, idx, possibleToBuy):
            


    */
}
