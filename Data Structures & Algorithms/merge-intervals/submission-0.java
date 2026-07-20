class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (!stack.isEmpty() && start <= stack.peek()[1]) {
                interval = new int[]{stack.peek()[0], Math.max(end, stack.peek()[1])};
                stack.pop();
            }
            stack.push(interval);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result.toArray(new int[0][]);
    }

    /*
        1 ---------3
        1 ------------------5

        1 ---------3
                        4 -------5
    */
}
