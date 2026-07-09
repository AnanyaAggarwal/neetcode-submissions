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
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        boolean isLeftMatch = (p.val == q.val)
        && isSameTree(p.left, q.left);
        if (isLeftMatch == false) {
            return false;
        }
        boolean isRightMatch = (p.val == q.val)
        && isSameTree(p.right, q.right);
        if (isRightMatch == false) {
            return false;
        }

        return isLeftMatch && isRightMatch;
    }   
}
