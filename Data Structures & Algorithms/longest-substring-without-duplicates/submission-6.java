class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() == 0) return 0;

        int l = 0, r = 0;
        int ans = 1;

        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            ans = Math.max(ans, r - l + 1);
            r += 1;
        }

        return ans;
    }

    /*
        zxyzxyz

        z -> 0
        x -> 1
        y -> 2

    */
}
