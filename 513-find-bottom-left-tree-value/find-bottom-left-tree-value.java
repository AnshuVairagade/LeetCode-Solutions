class Solution {
    int maxDepth=0;
    int value;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return value;
    }

    private void dfs(TreeNode root, int currDepth){
        if(root == null) return;
        if(root.left == null){
            if(currDepth > maxDepth){
                maxDepth = currDepth;
                value = root.val;
            }
        }

        dfs(root.left, currDepth+1);
        dfs(root.right, currDepth+1);
    }
}

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