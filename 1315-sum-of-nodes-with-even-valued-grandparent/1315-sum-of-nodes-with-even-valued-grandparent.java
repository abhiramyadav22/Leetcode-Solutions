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
    private int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        solve(root, null, null);
        return ans;
    }
    private void solve(TreeNode root, TreeNode par, TreeNode gpar) {
        if (root == null) return;
        if (gpar != null && gpar.val % 2 == 0) {
            ans += root.val;
        }
        solve(root.left, root, par);
        solve(root.right, root, par);
        }  
              }