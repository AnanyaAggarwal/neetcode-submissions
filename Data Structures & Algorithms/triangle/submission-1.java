class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] trg = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int colSize = triangle.get(i).size();
            trg[i] = new int[colSize];
            for (int j = 0; j < colSize; j++) {
                trg[i][j] = triangle.get(i).get(j);
            }
        }

        int[][] dp = new int[rows][rows];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return minimumTotal(0, 0, rows, trg, dp);
    }

    private int minimumTotal(int i, int j, int rows, int[][] trg, int[][] dp) {
        if (i == rows - 1) {
            return trg[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int downPath = trg[i][j] + minimumTotal(i + 1, j, rows, trg, dp);
        int diagPath = trg[i][j] + minimumTotal(i + 1, j + 1, rows, trg, dp);
        dp[i][j] = Math.min(downPath, diagPath);
        return dp[i][j];
    }
}