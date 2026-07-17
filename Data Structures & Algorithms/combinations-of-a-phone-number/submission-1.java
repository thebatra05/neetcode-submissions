class Solution {
    private final String[] mappings = {"", "", "abc", "def", 
                                                    "ghi", "jkl", "mno",
                                                    "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        result.add("");

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String currStr : result) {
                for (char c : mappings[digit - '0'].toCharArray()) {
                    temp.add(currStr + c);
                }
            }
            result = temp;
        }
        

        return result;
    }

    /*
                          /  
        2 -> "abc"      a -
        3 -> "def"      | \   
        4 -> "ghi"

        ["ad", "bd", "cd"]
    */
}
