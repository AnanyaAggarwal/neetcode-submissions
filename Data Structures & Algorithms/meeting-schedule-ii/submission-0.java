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
        int n = intervals.size();
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                // re-use the room
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}
