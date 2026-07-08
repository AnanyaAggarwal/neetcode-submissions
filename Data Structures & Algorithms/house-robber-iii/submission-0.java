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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();

        return dfs(root, dp);
    }

    private int dfs(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        int take = root.val;
        if (root.left != null) {
            take += dfs(root.left.left, dp) + dfs(root.left.right, dp);
        }
        if (root.right != null) {
            take += dfs(root.right.left, dp) + dfs(root.right.right, dp);
        }
        int notTake = dfs(root.left, dp) + dfs(root.right, dp);

        dp.put(root, Math.max(take, notTake));

        return dp.get(root);
    }
}