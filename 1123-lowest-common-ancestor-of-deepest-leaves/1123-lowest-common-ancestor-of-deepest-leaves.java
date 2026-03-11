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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth1 = depth(root.left), depth2 = depth(root.right);
        if (depth1 == depth2) {
            return root;
        }
        if (depth1 > depth2) {
            return lcaDeepestLeaves(root.left);
        }
        return lcaDeepestLeaves(root.right);
    }
    private int depth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
        return 0;
    }
}