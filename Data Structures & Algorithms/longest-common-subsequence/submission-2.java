class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; ++i) {
            if (text1.charAt(i) == text2.charAt(0)) dp[i][0] = 1;
            else dp[i][0] = i > 0 ? dp[i - 1][0] : 0;
        }
        for (int j = 0; j < n; ++j) {
            if (text1.charAt(0) == text2.charAt(j)) dp[0][j] = 1;
            else dp[0][j] = j > 0 ? dp[0][j - 1]: 0;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[m - 1][n - 1];
    }

    /*

        cat     crabt

        c   r   a   b   t

    c   1   1   1   1   1
    a   1   1   2   2   2         
    t   1   1   2   2   3

    */
}
