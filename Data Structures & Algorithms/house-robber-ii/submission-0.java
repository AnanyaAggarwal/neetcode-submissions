class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Exclude last house
        int[] numsMinusLast = new int[n-1];
        for (int i = 0; i < n-1; i++) numsMinusLast[i] = nums[i];

        // Exclude first house
        int[] numsMinusFirst = new int[n-1];
        for (int i = 0; i < n-1; i++) numsMinusFirst[i] = nums[i+1];

        int maxSum1 = maxSum(n - 2, numsMinusFirst, dp);
        Arrays.fill(dp, -1);
        int maxSum2 = maxSum(n - 2, numsMinusLast, dp);
        return Math.max(maxSum1, maxSum2);
    }

    private int maxSum(int idx, int[] nums, int[] dp) {
        if (idx == 0) {
            return nums[0];
        } else if (idx < 0) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int take = nums[idx] + maxSum(idx - 2, nums, dp);
        int notTake = maxSum(idx - 1, nums, dp);
        dp[idx] = Math.max(take, notTake);
        return dp[idx];
    }
}
