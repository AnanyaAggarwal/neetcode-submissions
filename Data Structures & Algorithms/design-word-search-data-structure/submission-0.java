class PrefixTreeNode {
    Map<Character, PrefixTreeNode> children;
    boolean isWord;

    PrefixTreeNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {
    PrefixTreeNode root;

    public WordDictionary() {
        root = new PrefixTreeNode();
    }

    public void addWord(String word) {
        PrefixTreeNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new PrefixTreeNode());
            }
            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return depthFirstSearch(word, 0, root);
    }

    private boolean depthFirstSearch(String word, int idx, PrefixTreeNode node) {
        if (idx == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(idx);

        if (c == '.') {
            // Try every child in the HashMap
            for (PrefixTreeNode child : node.children.values()) {
                if (child != null && depthFirstSearch(word, idx + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.children.containsKey(c)) {
                return false;
            }
            return depthFirstSearch(word, idx + 1, node.children.get(c));
        }
    }
}
