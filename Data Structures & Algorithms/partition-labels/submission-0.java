class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            lastSeen.put(s.charAt(i), i);
        }
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); ++i) {
            size += 1;
            end = Math.max(end, lastSeen.get(s.charAt(i)));
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;

    }
}
