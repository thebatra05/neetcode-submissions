class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0, r = 0;
        int maxFreq = 0;
        int ans = 0;

        while (r < s.length()) {
            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0) + 1);
            while ((r - l + 1) - Collections.max(freqMap.values()) > k) {
                freqMap.put(s.charAt(l), freqMap.getOrDefault(s.charAt(l), 0) - 1);
                l += 1;
            }

            ans = Math.max(ans, r - l + 1);
            r += 1;
        }

        return ans;
    }

    /*

        XYYX  k = 2

        

        X - 1
        Y - 1       2 - 1

    */
}
