class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = Arrays.stream(piles).max().getAsInt();
        int low = 1, high = maxValue;
        int k = 0;
        int ans = 0;

        while (low <= high) {
            k = low + (high - low) / 2;
            if (canEatAllBananas(piles, k, h)) {
                high = k - 1;
                ans = k;
            }
            else low = k + 1;
        }

        return ans;
    }

    private boolean canEatAllBananas(int[] piles, int k, int h) {
        long time = 0;
        for (int i = 0; i < piles.length; ++i) {
            time += (int) Math.ceil((double)piles[i] / k);
            System.out.print("time: " + time);
            if (time > h) {
                System.out.print("time: " + time);
                return false;
            }
        }

        return true;
    }

    /*
        0   1   2   3
        25  10  23  4

        k = 1.....25    h = 4 hours
        k = 1 + (25 - 1)/2 = 13

        2 + 1 + 2 

        low = 14

        0   1   2   3
        1   4   3   2

        k = 1.....4
        k = 1 + (4 - 1)/2 = 1 + 1 = 2



        hours = 6
        answer = 23
        0   1   2   3   4
        30  11  23  4   20

        k = 1.....max(piles) --- log(m)
        h >= len(piles)

        low = 1, high = max(piles) = 30

        k = low + (high - low) / 2 = 15

        if (canEatAllBananas(low, high, k)) high = k - 1;
        else low = k + 1;
    */
}
