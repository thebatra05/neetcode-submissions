class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int[] A = nums1;
        int[] B = nums2;

        int low = -1, high = A.length - 1;
        int total = A.length + B.length;
        int half = total / 2;

        while (true) {
            int i = low + (high - low) / 2;
            int j = half - i - 2;
            int Aleft = (i >= 0 ? A[i] : Integer.MIN_VALUE);
            int Aright = (i + 1 < A.length ? A[i + 1] : Integer.MAX_VALUE);
            int Bleft = (j >= 0 ? B[j] : Integer.MIN_VALUE);
            int Bright = (j + 1 < B.length ? B[j + 1] : Integer.MAX_VALUE);
            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) return Math.min(Aright, Bright);
                else 
                    return ((double) Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            else if (Aleft > Bright) high = i - 1;
            else low = i + 1;
        }
    }

    /*

        0   1   
        1   2

        0
        3       low = 0, high = 0, half = 1

        i = 0 + 0/2 = 0
        j = 1 - 0 - 2 = -1

        high = -1

        max(1, 2) + min(3, 4) / 2 = (2 + 3) / 2 = 2.5

        0   1   2   3   4   5
        1   2   3   4   5   6
                                    half = 5
        0   1   2   3
        1   2   3   4       low = 0, high = 3, i = 3/2 = 1

        j = 5 - 1 -2 = 2

    */
}
