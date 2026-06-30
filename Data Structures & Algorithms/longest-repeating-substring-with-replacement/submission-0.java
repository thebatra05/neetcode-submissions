class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        
        while (r < s.length()) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            while ((r - l + 1) - Collections.max(mp.values()) > k) {
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                l += 1;
            }
            ans = Math.max(ans, r - l + 1);
            r += 1;
        }

        return ans;
    }

    /*

        XYYX
        
    */
}
