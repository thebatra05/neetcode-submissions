class Solution {
    private final Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        return helper(s, wordSet);
    }

    private boolean helper(String s, Set<String> wordSet) {
        if (s.isEmpty() || wordSet.contains(s)) return true;
        
        if (memo.containsKey(s)) return memo.get(s);

        for (int i = 0; i < s.length(); ++i) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);
            if (wordSet.contains(left) && helper(right, wordSet)) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);

        return false;
    }

    /*

    */
}