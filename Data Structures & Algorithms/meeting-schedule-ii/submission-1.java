/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0;

        for (Interval interval : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(interval.end);
                ans += 1;
            }
            else {
                if (interval.start >= minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(interval.end);
                }
                else {
                    minHeap.add(interval.end);
                    ans += 1;
                }
            }
        }

        return ans;
    }

    /*
        0-------------------------------40
            5-----10
                        15-----20


                        10
                        20
                        40
    */
}
