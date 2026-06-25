class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) count[c - 'a']++;
            String keyStr = Arrays.toString(count);
            anagramsMap.put(keyStr, anagramsMap.getOrDefault(keyStr, new ArrayList<>()));
            anagramsMap.get(keyStr).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
