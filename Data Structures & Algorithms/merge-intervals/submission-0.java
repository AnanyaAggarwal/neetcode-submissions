class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> s = new Stack<>();
        s.push(intervals[0]);

        for (int[] interval : intervals) {
            int[] top = s.peek();
            if (interval[0] <= top[1]) {
                int[] overlap = s.pop();
                s.push(new int[]{overlap[0], Math.max(overlap[1], interval[1])});
            } else {
                s.push(interval);
            }
        }

        return s.toArray(new int[s.size()][]);
    }
}
