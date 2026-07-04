class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][r.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcs(s.length() - 1, r.length() - 1, dp, s, r);
    }

    private int lcs(int i, int j, int[][] dp, String s1, String s2) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(i - 1, j - 1, dp, s1, s2);
        } else {
            dp[i][j] = Math.max(lcs(i - 1, j, dp, s1, s2), lcs(i, j - 1, dp, s1, s2));
        }
        return dp[i][j];
    }
}