class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            anagramsMap.put(keyStr, anagramsMap.getOrDefault(keyStr, new ArrayList<>()));
            anagramsMap.get(keyStr).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
