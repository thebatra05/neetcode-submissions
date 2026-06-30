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
        int count = countT.size();

        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        
        Map<Character, Integer> countS = new HashMap<>();

        while (r < s.length()) {
            countS.put(s.charAt(r), countS.getOrDefault(s.charAt(r), 0) + 1);
            while (countS.size() >= count && isTContainedInS(countT, countS)) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                countS.put(s.charAt(l), countS.get(s.charAt(l)) - 1);
                if (countS.get(s.charAt(l)) == 0) countS.remove(s.charAt(l));
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
