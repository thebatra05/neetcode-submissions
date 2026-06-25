class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int area = 0;

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int mid = height[stack.pop()];
                if (!stack.empty()) {
                    int right = height[i];
                    int left = height[stack.peek()];
                    int h = Math.min(right, left) - mid;
                    int w = i - stack.peek() - 1;
                    area += h * w;
                }
            }
            stack.push(i);
        }

        return area;
    }

    /*
         0 1 2 3 4 5 6 7 8 9
        [0,2,0,3,1,0,1,3,2,1]
        
                3, 3
        0, 2
        2, 1

    */
}
