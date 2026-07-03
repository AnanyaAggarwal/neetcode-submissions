class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return change(coins.length - 1, amount, dp, coins);
    }

    private int change(int i, int amount, int[][] dp, int[] coins) {
        if (i == 0) {
            return amount % coins[i] == 0 ? 1 : 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int notTake = change(i - 1, amount, dp, coins);
        int take = 0;
        if (amount >= coins[i]) {
            take = change(i, amount - coins[i], dp, coins);
        }
        dp[i][amount] = notTake + take;

        return dp[i][amount];
    }
}
