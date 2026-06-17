class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0
        || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(0, 0));
        grid[0][0] = 1; // mark as visited

        int length = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = q.poll();
                int r = pair.getKey();
                int c = pair.getValue();

                if (r == rows - 1 && c == cols - 1) {
                    return length;
                }

                int[][] neighbours = {{r, c + 1}, {r + 1, c}, {r - 1, c},
                {r, c - 1}, {r + 1, c + 1}, {r - 1, c - 1}, {r - 1, c + 1},
                {r + 1, c - 1}};

                for (int j = 0; j < 8; j++) {
                    int newR = neighbours[j][0];
                    int newC = neighbours[j][1];
                    if (Math.min(newR, newC) < 0 || newR == rows
                    || newC == cols || grid[newR][newC] == 1) {
                        continue;
                    }

                    q.offer(new Pair<>(newR, newC));
                    grid[newR][newC] = 1; // mark as visited
                }
            }
            length++; // incremented after processing every level
        }

        return -1;
    }
}