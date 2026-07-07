class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) return Math.abs(nums[i]);
            nums[idx] *= -1;
        }

        return 0;
    }

    /*

        0   1   2   3   4
        -1  3   4   2   2

        n + 1 = 4 + 1   [1, 4]

        0 -> 1 -> 2 -> 3 
                    | -- |



    */
    
}
