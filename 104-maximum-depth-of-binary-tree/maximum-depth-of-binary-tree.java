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
    private int count(TreeNode root){
        if(root == null) return 0;
        
        int lt = count(root.left);
        int rt = count(root.right);

        return 1+Math.max(lt, rt);
    }

    public int maxDepth(TreeNode root) {
        return count(root);
    }
}