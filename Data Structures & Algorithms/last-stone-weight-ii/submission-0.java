class Solution {
    int sum = 0;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum/2;

        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(n - 1, 0, dp, target, stones);
    }

    private int dfs(int i, int total, int[][] dp, int target, int[] stones) {
        if (i < 0 || total >= target) {
            return (Math.abs(total - (sum-total)));
        }

        if (dp[i][total] != -1) {
            return dp[i][total];
        }

        int notTake = dfs(i - 1, total, dp, target, stones);
        int take = dfs(i - 1, total + stones[i], dp, target, stones);
        dp[i][total] = Math.min(notTake, take);

        return dp[i][total];
    }
}