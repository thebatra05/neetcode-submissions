class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;

        while (r < s.length()) {
            if (mp.containsKey(s.charAt(r))) {
                l = Math.max(mp.get(s.charAt(r)) + 1, l);
            }
            ans = Math.max(ans, r - l + 1);
            mp.put(s.charAt(r), r);
            r += 1;
        }

        return ans;
    }
}
