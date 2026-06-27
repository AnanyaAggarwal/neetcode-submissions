class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int maxLen = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            windowFreq.put(r, windowFreq.getOrDefault(r, 0) + 1);
            maxFreq = Math.max(maxFreq, windowFreq.get(r));

            while (k < (right - left + 1) - maxFreq) {
                char l = s.charAt(left);
                windowFreq.put(l, windowFreq.getOrDefault(l, 0) - 1);
                left++;
            }

            int currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);
            right++;
        }

        return maxLen;
    }
}
