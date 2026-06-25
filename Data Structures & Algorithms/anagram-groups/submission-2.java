class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> freqToGroupMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] freq = new int[26];
            for (char c : strs[i].toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            freqToGroupMap
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>(freqToGroupMap.values());
        return res;
    }
}
