class PrefixTreeNode {
    Map<Character, PrefixTreeNode> children;
    boolean isWord;

    PrefixTreeNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class PrefixTree {
    PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode();
    }

    public void insert(String word) {
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
        PrefixTreeNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
