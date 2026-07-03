class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcs(n1 - 1, n2 - 1, dp, text1, text2);
    }

    private int lcs(int i1, int i2, int[][] dp, String text1, String text2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        // match case
        if (text1.charAt(i1) == text2.charAt(i2)) {
            dp[i1][i2] = 1 + lcs(i1 - 1, i2 - 1, dp, text1, text2);
        } else {
            // not match case
            dp[i1][i2] = Math.max(lcs(i1 - 1, i2, dp, text1, text2),
            lcs(i1, i2 - 1, dp, text1, text2));
        }

        return dp[i1][i2];
    }
}
