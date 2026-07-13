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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(0, n - 1, 0, n - 1, inMap, preorder,
        inorder);
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart,
    int inEnd, HashMap<Integer, Integer> inMap, int[] preorder, int[] inorder) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inMap.get(rootVal);
        int numOfleftTreeEl = inRootIdx - inStart;
        root.left = buildTree(preStart + 1, preStart + numOfleftTreeEl,
        inStart, inRootIdx - 1, inMap, preorder, inorder);

        root.right = buildTree(preStart + numOfleftTreeEl + 1, preEnd,
        inRootIdx + 1, inEnd, inMap, preorder, inorder);

        return root;
    }
}
