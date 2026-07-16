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
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // why this? cuz there can be negative integers
        // so we can skip taking children all together by comparing with 0
        int leftMax = Math.max(left, 0);
        int rightMax = Math.max(right, 0);

        // global path sum - V shape including current node
        int vPathSum = root.val + leftMax + rightMax;
        int straightPathSum = root.val + Math.max(leftMax, rightMax);
        maxPathSum = Math.max(maxPathSum, Math.max(vPathSum, straightPathSum));

        // straight path
        return straightPathSum;
    }
}
