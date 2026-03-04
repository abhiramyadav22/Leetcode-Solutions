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
    int max = 0;
    int ans = 0;

    public int deepestLeavesSum(TreeNode root) {
        solve(root, 1);
        return ans;
    }

    private void solve(TreeNode n, int l) {
        if (n == null) return;

        if (l == max) ans += n.val;
        if (l > max) {
            ans = n.val;
            max = l;
        }
        solve(n.left, l + 1);
        solve(n.right, l + 1);
    }
}