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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        // Level order traversal
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("N,");
                continue;
            }
            sb.append(curr.val).append(",");
            q.offer(curr.left); // we have to push null children as well
            q.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;

        while (!q.isEmpty() && idx < tokens.length) {
            TreeNode curr = q.poll();

            String leftVal = tokens[idx++];
            if (!leftVal.equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(leftVal));
                curr.left = left;
                q.offer(left);
            }
            
            if (idx < tokens.length) {
                String rightVal = tokens[idx++];
                if (!rightVal.equals("N")) {
                    TreeNode right = new TreeNode(Integer.parseInt(rightVal));
                    curr.right = right;
                    q.offer(right);
                }
            }
        }

        return root;
    }
}
