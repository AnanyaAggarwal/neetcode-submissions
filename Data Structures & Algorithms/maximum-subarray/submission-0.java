class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int size = nums.length;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
