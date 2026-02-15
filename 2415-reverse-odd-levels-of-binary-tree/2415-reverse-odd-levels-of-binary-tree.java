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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root != null) {
            traverse(root.left, root.right, 0);
        }
        return root;
    }
    static void traverse(TreeNode left, TreeNode right, int lvl){
        if(left == null || right == null) return;

        if(lvl % 2 == 0){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        traverse(left.left, right.right, lvl+1);
        traverse(left.right, right.left, lvl+1);
    }
}