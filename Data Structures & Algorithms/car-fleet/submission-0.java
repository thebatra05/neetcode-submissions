class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        List<int[]> positionSpeedList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            positionSpeedList.add(new int[]{position[i], speed[i]});
        }

        positionSpeedList.sort((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; ++i) {
            double time = (double)(target - positionSpeedList.get(i)[0]) / positionSpeedList.get(i)[1];
            if (stack.isEmpty() || time > stack.peek()) stack.push(time);
        }

        return stack.size();

    }

    /*

                                                       target
        0       1           4           7               10
      Car2      Car1       Car0        Car3
     Speed=1   Speed=2    Speed=2      Speed=1
        Position
        0   1   2   3
        4   1   0   7

        Speed
        0   1   2   3
        2   2   1   1

        time = 3
        time = 6/2 = 3

        9/2 = 4.5 
        10

        [[7, 1], [4, 2], [1, 2], [0, 1]]
                                   i

        4.5
        3

    */
}
