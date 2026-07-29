class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp1 = 1, dp2 = 0;
        int dp = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') dp = 0;
            else dp = dp1;

            if (i < n - 1) {
                if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7') {
                    dp += dp2;
                }
            }
            int temp = dp1;
            dp1 = dp;
            dp2 = temp;
        }

        return dp;
    }

    private int dfs(String s, int idx, int[] memo) {
        if (idx >= s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (memo[idx] != -1) return memo[idx];
        
        int numWays = dfs(s, idx + 1, memo);
        if (idx < s.length() - 1) {
            if (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7') {
                numWays += dfs(s, idx + 2, memo);
            }
        }

        memo[idx] = numWays;

        return numWays;
    }

    /*
        "2 2 6"
         3 2 1 1

         "0 6"
            1  1
    */


}
