class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];
        if (origColor == color) {
            return image;
        }
        
        dfs(image, sr, sc, origColor, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int origColor,
    int color) {
        int rows = image.length;
        int cols = image[0].length;

        if (Math.min(sr, sc) < 0 || sr == rows || sc == cols
        || image[sr][sc] != origColor) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr + 1, sc, origColor, color);
        dfs(image, sr, sc + 1, origColor, color);
        dfs(image, sr - 1, sc, origColor, color);
        dfs(image, sr, sc - 1, origColor, color);

        return;
    }
}