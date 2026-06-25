class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return n;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 1;
        int currLen = 0;
        
        for (int num : set) {
            currLen = 0;
            if (set.contains(num - 1)) {
                while (set.contains(num - 1)) num = num - 1;
                while (set.contains(num)) {
                    num += 1;
                    currLen++;
                }
                ans = Math.max(ans, currLen);
            }
        }

        return ans;
    }

    /*
        0   3   2   5   4   6   1   1

        1   3   4   5   6   7   0   2
    */  
}
