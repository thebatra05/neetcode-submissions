class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] countS1 = new int[26];
        for (char c : s1.toCharArray()) countS1[c - 'a']++;

        int l = 0, r = 0;
        int[] count = new int[26];

        while (r < s2.length()) {
            count[s2.charAt(r) - 'a']++;
            while ((r - l + 1) > s1.length()) {
                count[s2.charAt(l) - 'a']--;
                l += 1;
            }
            if (Arrays.equals(count, countS1)) return true;
            r += 1;
        }

        return false;
    }

    /*
        s1 = "abc", s2 = "lecabee"
    */
}
