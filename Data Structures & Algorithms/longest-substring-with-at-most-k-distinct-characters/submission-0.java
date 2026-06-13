class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            charFreq.put(r, charFreq.getOrDefault(r, 0) + 1);

            // constraint violated when distinct > k
            while (charFreq.size() > k) {
                char l = s.charAt(left);
                charFreq.put(l, charFreq.get(l) - 1);
                if (charFreq.get(l) == 0) {
                    charFreq.remove(l);
                }
                left++;
            }

            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        return maxLen;
    }
}
