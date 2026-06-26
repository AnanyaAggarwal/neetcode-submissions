class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                int currArea = Math.min(maxLeft, maxRight) - height[left];
                left++;
                res += currArea;
            } else {
                int currArea = Math.min(maxLeft, maxRight) - height[right];
                right--;
                res += currArea;
            }
        }

        return res;
    }
}
