class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;

        int l = 0, r = 0;

        while (r < s2.length()) {
            count[s2.charAt(r) - 'a']--;
            while (r - l + 1 > s1.length()) {
                char leftChar = s2.charAt(l);
                count[leftChar - 'a']++;
                l += 1;
            }
            if (allZeroes(count)) return true;
            r += 1;
        }

        return false;
    }

    private boolean allZeroes(int[] count) {
        for (int num : count) if (num != 0) return false;

        return true;
    }

    /*
        l e c a
        0 1 2 3
    */
}
