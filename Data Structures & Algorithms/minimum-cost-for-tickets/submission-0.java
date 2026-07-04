class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return dfs(n - 1, dp, days, costs);
    }

    private int dfs(int i, int[] dp, int[] days, int[] costs) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int oneDayPass = costs[0] + dfs(i - 1, dp, days, costs);

        int j = i;
        while (j >= 0 && days[j] > days[i] - 7) {
            j = j - 1;
        }
        int sevDayPass = costs[1] + dfs(j, dp, days, costs);
        
        int k = i;
        while (k >= 0 && days[k] > days[i] - 30) {
            k = k - 1;
        }
        int thirtyDayPass = costs[2] + dfs(k, dp, days, costs);
        dp[i] = Math.min(oneDayPass, Math.min(sevDayPass, thirtyDayPass));

        return dp[i];
    }
}