class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
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
        "12"
    */


}
