class Solution {
    TreeNode nextRight = null;

    public void flatten(TreeNode root) {
        flattening(root);
    }

    private void flattening(TreeNode root){
        if(root == null) return;

        flattening(root.right);
        flattening(root.left);

        root.left = null;
        root.right = nextRight;

        nextRight = root;
    }
}