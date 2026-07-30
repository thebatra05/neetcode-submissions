class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        
        int ans = 0;

        for (int num : set) {
            int val = num;
            int len = 0;
            while (set.contains(val - 1)) val = val - 1;
            while (set.contains(val)) {
                val += 1;
                len += 1;
            }
        
            ans = Math.max(ans, len);
        }

        return ans;
    }
}
