class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                }
                else if (sum < target) start++;
                else end--;
            }
        }

        return result;
    }
}
