class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        if (Math.min(r, c) < 0 || r == rows || c == cols
        || grid[r][c] == 0) {
            return 0;
        }

        count++;
        grid[r][c] = 0;

        count += dfs(grid, r + 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c - 1);

        return count;
    }
}
