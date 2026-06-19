class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adjListMap = new HashMap<>();
      Map<Character, Integer> indegrees = new HashMap<>();
      for (String word : words) {
        for (char c : word.toCharArray()) {
            adjListMap.putIfAbsent(c, new HashSet<>());
            indegrees.putIfAbsent(c, 0);
        }
    }

      for (int i = 0; i < words.length - 1; i++) {
        String word1 = words[i];
        String word2 = words[i+1];
        int minLen = Math.min(word1.length(), word2.length());
        if (word1.length() > word2.length() && word1.startsWith(word2)) {
            return "";
        }

        for (int j = 0; j < minLen; j++) {
            if (word1.charAt(j) != word2.charAt(j)) {
                if (adjListMap.get(word1.charAt(j)).add(word2.charAt(j))) {
                    indegrees.put(word2.charAt(j), indegrees.get(word2.charAt(j)) + 1);
                }
                break;
            }
        }
      }

      Queue<Character> q = new LinkedList<>();
      for (char c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                q.offer(c);
            }
      }

      StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
        char curr = q.poll();
        sb.append(curr);

        for (char neighbour : adjListMap.getOrDefault(curr, new HashSet<>())) {
            indegrees.put(neighbour, indegrees.get(neighbour) - 1);
            if (indegrees.get(neighbour) == 0) {
                q.offer(neighbour);
            }
        }
    }

    if (sb.length() != indegrees.size()) {
        return "";
    }
    
    return sb.toString();
    }
}
