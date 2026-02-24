class Solution {
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) return;

        // build binary number directly
        sum = (sum << 1) | root.val;

        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }
}