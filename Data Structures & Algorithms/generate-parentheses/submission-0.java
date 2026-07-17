class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, result, new StringBuilder());

        return result;
    }

    private void backtrack(int open, int close, int n, List<String> result, StringBuilder sb) {
        if (open > n || close > n) return;
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }
        if (open > close) {
            sb.append(")");
            backtrack(open, close + 1, n, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("(");
        backtrack(open + 1, close, n, result, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    /*

        if open > close -> can put a close
        - can add open always (as long as open < n)
    */
}
