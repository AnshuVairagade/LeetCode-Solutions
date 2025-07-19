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
    private int count(TreeNode root, int maxVal){
        if(root == null) return 0;

        int curr = 0;
        if(root.val >= maxVal) curr = 1;
        maxVal = Math.max(maxVal, root.val);
        int left = count(root.left, maxVal);
        int right = count(root.right, maxVal);

        return curr + left + right;
    }

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return count(root, root.val);
    }
}