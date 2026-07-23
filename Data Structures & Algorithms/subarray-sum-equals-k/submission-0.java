class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int ans = 0;

        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k))
                ans += map.get(prefixSum - k);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }

    /*

        2   -1  1   2       k = 2

        0 -> 1
        2 - 2 = 0 ? 1
        2 -> 1
        2 + -1 = 1
        1 - 2 = -1 -> not present
        -
        
    */
}