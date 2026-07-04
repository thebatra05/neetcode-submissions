class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int area = 0;

        for (int i = 0; i < n; ++i) {
            int startIdx = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                int h = stack.peek()[0];
                startIdx = stack.peek()[1];
                stack.pop();
                area = Math.max(area, h * (i - startIdx));
            }
            stack.push(new int[]{heights[i], startIdx});
        }

        while (!stack.isEmpty()) {
            int[] heightIdx = stack.pop();
            area = Math.max(area, heightIdx[0] * (n - heightIdx[1]));
        }

        return area;
    }

    /*
            0   1   2   3   4   5
            7   1   7   2   2   4

            0   1   2   3   4   5   6   
            1   2   3   4   5   6   7

            1   2   3   4   5   6   7
            6   10  12  16  15  12   1


            0   1   2   3   4   5   6
            7   6   5   4   3   2   1

            7   

    */
}
