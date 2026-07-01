class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(rows, cols, 0, 0, grid, dp);
    }

    public int dfs(int rows, int cols, int i, int j, int[][] grid,
    int[][] dp) {
        if (i >= rows || j >= cols) {
            return Integer.MAX_VALUE;
        } else if (i == rows - 1 && j == cols - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int rightPath = dfs(rows, cols, i, j + 1, grid, dp);
        int downPath = dfs(rows, cols, i + 1, j, grid, dp);
        dp[i][j] = grid[i][j] + Math.min(rightPath, downPath);
        return dp[i][j];
    }
}