class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePaths(0, 0, m, n, obstacleGrid, dp);
    }

    private int uniquePaths(int i, int j, int m, int n,
    int[][] obstacleGrid, int[][] dp) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        } else if (i == m-1 && j == n-1) {
            return 1;
        } 

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = uniquePaths(i + 1, j, m, n, obstacleGrid, dp)
        + uniquePaths(i, j + 1, m, n, obstacleGrid, dp);
        return dp[i][j];
    }
}