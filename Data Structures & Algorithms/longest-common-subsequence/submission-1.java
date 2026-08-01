class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(text1, 0, text2, 0, memo);
    }

    private int dfs(String text1, int idx1, String text2, int idx2, int[][] memo) {
        if (idx1 == text1.length() || idx2 == text2.length()) return 0;

        if (memo[idx1][idx2] != -1) return memo[idx1][idx2];

        int len = 0;
        if (text1.charAt(idx1) == text2.charAt(idx2))
            len = 1 + dfs(text1, idx1 + 1, text2, idx2 + 1, memo);
        
        memo[idx1][idx2] = Math.max(len, Math.max(dfs(text1, idx1 + 1, text2, idx2, memo), 
                                    dfs(text1, idx1, text2, idx2 + 1, memo)));

        return memo[idx1][idx2];
    }

    /*

        cat     crabt

        c   r   a   b   t

    c   1   0   0   0   0
    a   1      
    t   0

    */
}
