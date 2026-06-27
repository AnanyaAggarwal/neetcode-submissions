class Solution {
    public int[][] generateMatrix(int n) {
        int endNum = n * n;
        int[][] matrix = new int[n][n];

        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int startNum = 1;

        while (top <= bottom && left <= right && startNum <= endNum) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = startNum++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = startNum++;
            }
            right--;

            if (top > bottom || left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = startNum++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = startNum++;
            }
            left++;
        }
        return matrix;
    }
}