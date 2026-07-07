class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        int slow2 = 0;

        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
        
    }

    /*

        0   1   2   3   4
        1   3   4   2   2

        n + 1 = 4 + 1   [1, 4]

        0 -> 1 -> 2 -> 3 
                    | -- |

        


    */
    
}
