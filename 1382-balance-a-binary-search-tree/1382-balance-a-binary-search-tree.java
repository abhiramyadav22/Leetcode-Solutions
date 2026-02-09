class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return createBST(0, list.size() - 1);
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    TreeNode createBST(int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createBST(start, mid - 1);
        root.right = createBST(mid + 1, end);
        return root;
    }
}