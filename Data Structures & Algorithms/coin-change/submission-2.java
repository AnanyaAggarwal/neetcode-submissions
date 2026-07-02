class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = coinChange(coins.length - 1, coins, amount);
        return result >= 1e9 ? -1 : result;
    }

    private int coinChange(int i, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (i == 0 && amount % coins[0] == 0) {
            return amount / coins[0];
        } else if (i <= 0) {
            return (int)1e9;
        }

        int notTake = coinChange(i - 1, coins, amount);
        int take = (int)1e9;
        if (amount >= coins[i]) {
            take = 1 + coinChange(i, coins, amount - coins[i]);
        }

        return Math.min(notTake, take);
    }
}
