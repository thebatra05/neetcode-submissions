class Solution {
    private Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        
        return backtrack(s, wordSet);
    }

    private boolean backtrack(String s, Set<String> wordSet) {
        if (s.length() == 0 || wordSet.contains(s)) return true;
        if (memo.containsKey(s)) return memo.get(s);

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            left.append(s.charAt(i));
            String right = s.substring(i + 1, s.length());
            if (wordSet.contains(left.toString()) && backtrack(right, wordSet)) {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);

        return false;
    }
}
