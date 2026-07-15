class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int min = 0;
        int max = 1000000000;
        int maxScore = Integer.MIN_VALUE;

        while (min <= max) {
            int mid = min + (max - min)/2;
            boolean[][] visited = new boolean[rows][cols];
            if (canReach(0, 0, rows, cols, mid, visited, grid)) {
                maxScore = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return maxScore;
    }

    private boolean canReach(int i, int j, int rows, int cols,
    int target, boolean[][] visited, int[][] grid) {
        if (i < 0 || i >= rows || j < 0 || j >= cols
        || grid[i][j] < target || visited[i][j]) {
            return false;
        }

        if (i == rows - 1 && j == cols - 1) {
            return true;
        }

        visited[i][j] = true;

        return canReach(i + 1, j, rows, cols, target, visited, grid)
        || canReach(i, j + 1, rows, cols, target, visited, grid)
        || canReach(i - 1, j, rows, cols, target, visited, grid)
        || canReach(i, j - 1, rows, cols, target, visited, grid);
    }
}
