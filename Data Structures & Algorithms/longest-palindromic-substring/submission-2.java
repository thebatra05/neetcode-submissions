class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int startIdx = 0;

        for (int i = 0; i < n; ++i) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    startIdx = left;
                }
                left--;
                right++;
            }
            // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    startIdx = left;
                }
                left--;
                right++;
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }

    /*
        0 1 2 3 4
        a b a b d

        bb
        0 1
    */
}
