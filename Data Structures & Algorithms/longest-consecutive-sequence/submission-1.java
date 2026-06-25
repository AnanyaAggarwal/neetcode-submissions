class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> arr = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (arr.contains(curr - 1)) {
                continue;
            }
            int len = 0;
            while (arr.contains(curr)) {
                len++;
                curr = curr + 1;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
