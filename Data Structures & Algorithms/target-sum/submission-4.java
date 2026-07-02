class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums.length - 1, target, nums);
    }

    private int findTargetSumWays(int i, int target, int[] nums) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            int ways = 0;
            if (nums[0] == target) {
                ways++;
            }
            if (-1 * nums[0] == target) {
                ways++;
            }
            return ways;
        }

        int plusWay = findTargetSumWays(i - 1, target - nums[i], nums);
        int minusWay = findTargetSumWays(i - 1, target + nums[i], nums);
        return plusWay + minusWay;
    }
}
