class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int max1 = pq.poll();
            int max2 = pq.poll();

            if (max1 != max2) {
                int diff = Math.abs(max1 - max2);
                pq.offer(diff);
            } 
        }
        
        if (!pq.isEmpty()) {
            return pq.peek();
        }
        return 0;
    }
}
