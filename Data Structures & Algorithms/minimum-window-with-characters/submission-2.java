class Solution {
    private boolean isTContainedInS(Map<Character, Integer> countT, Map<Character, Integer> countS) {
        for (Map.Entry<Character, Integer> entry : countT.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (!countS.containsKey(key) || countS.get(key) < val) return false;
        }

        return true;
    }
    
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> countT = new HashMap<>();;
        for (char c : t.toCharArray()) countT.put(c, countT.getOrDefault(c, 0) + 1);
        int need = countT.size();

        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        
        Map<Character, Integer> countS = new HashMap<>();
        int have = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            countS.put(c, countS.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && countS.get(c).equals(countT.get(c))) have++;
            while (have == need) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                char leftChar = s.charAt(l);
                countS.put(leftChar, countS.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && countS.get(leftChar) < countT.get(leftChar)) have--;
                l += 1;
            }
            r += 1;
        }

        return ans;
    }

    /*
        s = "OUZODYXAZV", t = "XYZ"
    */
}
