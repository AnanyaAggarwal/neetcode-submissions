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
    public boolean isValidBST(TreeNode root) {
        int[] range = new int[2];
        range[0] = Integer.MIN_VALUE;
        range[1] = Integer.MAX_VALUE;

        return isValidBST(root, range);
    }

    private boolean isValidBST(TreeNode root, int[] range) {
        if (root == null) {
            return true;
        }

        if (root.val <= range[0] || root.val >= range[1]) {
            return false;
        }

        boolean isLeftMatch = isValidBST(root.left, new int[]{range[0], root.val});
        boolean isRightMatch = isValidBST(root.right, new int[]{root.val, range[1]});

        return isLeftMatch && isRightMatch;
    }
}
