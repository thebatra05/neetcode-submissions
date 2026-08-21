class Solution {
    public String foreignDictionary(String[] words) {
              Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) map.put(c, new HashSet<>());
            }
        }
        int[] indegree = new int[26];

        for (int i = 1; i < words.length; ++i) {
            String firstWord = words[i - 1];
            String secondWord = words[i];
            int minLen = Math.min(firstWord.length(), secondWord.length());
            if (firstWord.substring(0, minLen).equals(secondWord.substring(0, minLen)))
                if (firstWord.length() > secondWord.length()) return "";
            for (int j = 0; j < minLen; ++j) {
                if (firstWord.charAt(j) != secondWord.charAt(j)) {
                    if (map.get(firstWord.charAt(j)).add(secondWord.charAt(j))) 
                        indegree[secondWord.charAt(j) - 'a']++;
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (indegree[entry.getKey() - 'a'] == 0) q.add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char neigh : map.get(c)) {
                indegree[neigh - 'a']--;
                if (indegree[neigh - 'a'] == 0) q.add(neigh);
            }
        }

        String res = sb.toString();

        return res.length() == map.size() ? res : "";
    }
}
