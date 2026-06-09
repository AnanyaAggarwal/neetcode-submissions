/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair<TreeNode, TreeNode>> nodeQ = new LinkedList<>();
        nodeQ.offer(new Pair<>(p, q));

        while (!nodeQ.isEmpty()) {
            Pair<TreeNode, TreeNode> currPair = nodeQ.poll();

            if (currPair.getKey() == null && currPair.getValue() == null) {
                continue;
            } else if (currPair.getKey() == null || currPair.getValue() == null) {
                return false;
            } else if (currPair.getKey().val != currPair.getValue().val) {
                return false;
            }

            nodeQ.offer(new Pair<>(currPair.getKey().left, currPair.getValue().left));
            nodeQ.offer(new Pair<>(currPair.getKey().right, currPair.getValue().right));
        }

        return true;
    }
}
