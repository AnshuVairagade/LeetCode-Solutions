class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root, subRoot);
    }


    private boolean traverse(TreeNode root, TreeNode subRoot){
        if(root == null) return false;

        if(check(root, subRoot) || traverse(root.left, subRoot) || 
                                                    traverse(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    private boolean check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null || root.val != subRoot.val) return false;

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}