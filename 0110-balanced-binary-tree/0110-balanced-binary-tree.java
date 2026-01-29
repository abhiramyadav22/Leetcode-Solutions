class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfshight (root) !=-1;

    }
    int dfshight(TreeNode root) {
        if(root==null) return 0;


    int lh=dfshight (root.left);
    if(lh== -1) return -1;
    int rh=dfshight(root.right);
    if (rh== -1) return -1;
if(Math.abs(lh-rh)>1) return -1;
return Math.max(lh,rh)+1;

}
}