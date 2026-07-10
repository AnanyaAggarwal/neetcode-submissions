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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxTillNow) {
        if (root == null) {
            return 0;
        }
        
        int leftCount = 0;
        if (root.left != null) {
            int currMax = maxTillNow;
            if (root.left.val >= currMax) {
                currMax = root.left.val;
                leftCount++;
            }
            leftCount += dfs(root.left, currMax);
        }

        int rightCount = 0;
        if (root.right != null) {
            int currMax = maxTillNow;
            if (root.right.val >= currMax) {
                currMax = root.right.val;
                rightCount++;
            }
            rightCount += dfs(root.right, currMax);
        }
        
        return leftCount + rightCount;
    }
}
