class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = coinChange(coins.length - 1, coins, amount, dp);
        return result >= 1e9 ? -1 : result;
    }

    private int coinChange(int i, int[] coins, int amount, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (i == 0 && amount % coins[0] == 0) {
            return amount / coins[0];
        } else if (i <= 0) {
            return (int)1e9;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int notTake = coinChange(i - 1, coins, amount, dp);
        int take = (int)1e9;
        if (amount >= coins[i]) {
            take = 1 + coinChange(i, coins, amount - coins[i], dp);
        }
        dp[i][amount] = Math.min(notTake, take);

        return dp[i][amount];
    }
}
