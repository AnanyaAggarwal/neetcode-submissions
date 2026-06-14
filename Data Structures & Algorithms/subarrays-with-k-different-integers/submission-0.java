class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMostK = subarraysWithAtMostDistinct(nums, k);
        int atMostK1 = subarraysWithAtMostDistinct(nums, k-1);

        return atMostK - atMostK1;
    }

    private int subarraysWithAtMostDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {
            int r = nums[right];
            numFreq.put(r, numFreq.getOrDefault(r, 0) + 1);

            while (numFreq.size() > k) {
                int l = nums[left];
                numFreq.put(l, numFreq.get(l) - 1);
                if (numFreq.get(l) == 0) {
                    numFreq.remove(l);
                }
                left++;
            }
            int currLen = right - left + 1;
            count += currLen;
            right++;
        }

        return count;
    }
}