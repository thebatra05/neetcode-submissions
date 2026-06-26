class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0, r = 0;
        int ans = 0;

        while (r < s.length()) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l += 1;
            }
            ans = Math.max(ans, r - l + 1);
            charSet.add(s.charAt(r));
            r += 1;
        }

        return ans;
    }

    /*
        zxyzxyz
    */
}
