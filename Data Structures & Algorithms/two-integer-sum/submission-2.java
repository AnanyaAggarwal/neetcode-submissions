class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndexMap.containsKey(diff)) {
                return new int[]{numToIndexMap.get(diff), i};
            }
            numToIndexMap.put(nums[i], i);
        }
        return new int[]{-1};
    }
}
