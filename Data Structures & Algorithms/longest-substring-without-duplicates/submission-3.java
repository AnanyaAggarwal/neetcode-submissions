class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windowToIndex = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (windowToIndex.containsKey(r) && windowToIndex.get(r) >= left) {
                left = windowToIndex.get(r) + 1;
                windowToIndex.put(s.charAt(left), left);
            }

            windowToIndex.put(r, right);
            int currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);
            right++;
        }

        return maxLen;
    }
}
