class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> distinctFreqMap = new HashMap<>();
        int need = 0;

        for (char c : t.toCharArray()) {
            if (!distinctFreqMap.containsKey(c)) {
                need++;
            }
            distinctFreqMap.put(c, distinctFreqMap.getOrDefault(c, 0) + 1);
        }

        int distinctMatched = 0;
        int left = 0;
        int right = 0;
        int startIdx = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char r = s.charAt(right);
            distinctFreqMap.put(r, distinctFreqMap.getOrDefault(r, 0) - 1);
            
            if (distinctFreqMap.getOrDefault(r, 0) == 0) {
                distinctMatched++;
            }

            while (need == distinctMatched) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    startIdx = left;
                }

                char l = s.charAt(left);
                distinctFreqMap.put(l, distinctFreqMap.getOrDefault(l, 0) + 1);
                if (distinctFreqMap.getOrDefault(l, 0) == 1) {
                    distinctMatched--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
