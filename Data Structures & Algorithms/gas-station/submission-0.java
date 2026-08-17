class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
        
        int res = 0;
        int n = gas.length;
        int total = 0;

        for (int i = 0; i < n; ++i) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;
        
    }

    /*
        gas
        1   2   3   4
        cost
        2   2   4   1
    */
}
