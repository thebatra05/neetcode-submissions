class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            int compliment = target - numbers[i];
            int start = i + 1, end = n - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] == compliment) return new int[]{i + 1, mid + 1};
                else if (numbers[mid] > compliment) end = mid - 1;
                else start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
