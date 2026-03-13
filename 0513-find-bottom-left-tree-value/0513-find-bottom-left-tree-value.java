class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(q.peek() != null) {
            root = q.poll();
            if(root.right !=null) q.offer(root.right);
            if(root.left !=null) q.offer(root.left);
        }
        return root.val;
    }
}