class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        } else if (q.isEmpty()) {
            return -1;
        }

        return bfs(grid, q, fresh);
    }

    private int bfs(int[][] grid, Queue<Pair<Integer, Integer>> queue,
    int fresh) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                int r = pair.getKey();
                int c = pair.getValue();

                int[][] neighbours = {{r + 1, c}, {r, c + 1},
                {r - 1, c}, {r, c - 1}};
                for (int j = 0; j < 4; j++) {
                    int newR = neighbours[j][0];
                    int newC = neighbours[j][1];

                    if (Math.min(newR, newC) < 0 || newR == rows || newC == cols
                    || grid[newR][newC] == 0 || grid[newR][newC] == 2) {
                        continue;
                    }

                    grid[newR][newC] = 2;
                    fresh--;
                    queue.offer(new Pair<>(newR, newC));
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
