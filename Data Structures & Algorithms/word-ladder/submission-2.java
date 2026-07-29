class Solution {
    private Map<String, List<String>> getPatternMap(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            char[] ca = word.toCharArray();
            for (int i = 0; i < ca.length; ++i) {
                char temp = ca[i];
                ca[i] = '*';
                String key = String.valueOf(ca);
                System.out.println("key: " + key);
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(word);
                ca[i] = temp;
            }
        }
        return map;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Map<String, List<String>> map = getPatternMap(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int len = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; ++j) {
                String word = q.poll();
                if (word.equals(endWord)) return len;
                char[] ca = word.toCharArray();
                for (int i = 0; i < ca.length; ++i) {
                    char temp = ca[i];
                    ca[i] = '*';
                    String key = String.valueOf(ca);
                    for (String w : map.getOrDefault(key, new ArrayList<>())) {
                        if (visited.contains(w)) continue;
                        q.add(w);
                        visited.add(w);
                    }
                    ca[i] = temp;
                }
            }
            len += 1;
        }

        return 0;
    }
}
