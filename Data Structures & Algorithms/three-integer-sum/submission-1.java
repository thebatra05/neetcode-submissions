class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int start = i + 1, end = n - 1;
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                }
                else if (nums[start] + nums[end] < target) start++;
                else end--;
            }
        }

        return result;
    }
}
