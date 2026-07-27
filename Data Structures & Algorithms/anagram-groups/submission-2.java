class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!anagramsMap.containsKey(String.valueOf(ca))) 
                anagramsMap.put(key, new ArrayList<>());
            anagramsMap.get(key).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
