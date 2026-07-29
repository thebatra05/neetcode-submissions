class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordSet.remove(beginWord);
        int len = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; ++j) {
                String word = q.poll();
                if (word.equals(endWord)) return len;
                for (int i = 0; i < word.length(); ++i) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == word.charAt(i)) continue;
                        String neigh = word.substring(0, i) + c + word.substring(i + 1);
                        if (wordSet.contains(neigh)) {
                            q.add(neigh);
                            wordSet.remove(neigh);
                        }
                    }
                }
            }
            len += 1;
        }

        return 0;
    }
}
