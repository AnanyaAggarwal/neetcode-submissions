class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
    
        return maxSum(nums.length - 1, nums, dp);
    }

    private int maxSum(int idx, int[] nums, int[] dp) {
        if (idx == 0) {
            return nums[0];
        }
        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }

        int pick = nums[idx] + maxSum(idx-2, nums, dp);
        int notPick = 0 + maxSum(idx-1, nums, dp);
        dp[idx] = Math.max(pick, notPick);

        return dp[idx];
    }
}
