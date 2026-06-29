class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        // Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        int valForNegIdx = 0;

        // Tabulation approach
        for (int i = 1; i < n; i++) {
            int take = nums[i] + ((i >= 2) ? dp[i-2] : valForNegIdx);
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }

        return dp[n - 1];

        // return maxSum(nums.length - 1, nums, dp);
    }

    // Memoization approach
    // private int maxSum(int idx, int[] nums, int[] dp) {
    //     if (idx == 0) {
    //         return nums[0];
    //     }
    //     if (idx < 0) {
    //         return 0;
    //     }

    //     if (dp[idx] != Integer.MIN_VALUE) {
    //         return dp[idx];
    //     }

    //     int pick = nums[idx] + maxSum(idx-2, nums, dp);
    //     int notPick = 0 + maxSum(idx-1, nums, dp);
    //     dp[idx] = Math.max(pick, notPick);

    //     return dp[idx];
    // }
}
