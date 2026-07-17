class Solution {
    private final String[] mappings = new String[]{"", "", "abc", "def", 
                                                    "ghi", "jkl", "mno",
                                                    "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder sb, List<String> result) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char letter : mappings[digits.charAt(idx) - '0'].toCharArray()) {
            sb.append(letter);
            backtrack(digits, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /*

        2 -> "abc"
        3 -> "def"
        4 -> "ghi"
    */
}
