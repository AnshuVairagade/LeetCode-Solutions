class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] list = new int[1];
        list[0] = 0;
        int kthval = traverse(root, list, k);
        return kthval;
    }

    private int traverse(TreeNode root, int[] list, int k){
        if(root == null) return -1;

        int left = traverse(root.left, list, k);
        list[0]++;
        if(list[0] == k) return root.val;
        int right = traverse(root.right, list, k);

        return left == -1 ? right : left;
    }
}

/* Different ways to solve the problem
1) PriorityQueue
2) Array
3) Traversal and storing
4) Traversal and counting
5) Morris traversal
 */


/*

Intuition : Count the traversal

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        int kthval = traverse(root, list, k);
        return kthval;
    }

    private int traverse(TreeNode root, List<Integer> list, int k){
        if(root == null) return -1;

        int left = traverse(root.left, list, k);
        list.add(root.val);
        if(list.size() == k) return root.val;
        int right = traverse(root.right, list, k);

        return left == -1 ? right : left;
    }
}
*/


/* 
Incomplete code

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int kthval = traverse(root, new int[]{k});
    }

    private int traverse(TreeNode root, int cnt, int k){
        if(root = null) return -1;
        
        int left = traverse(root, --cnt[0]);
        if(--cnt[0] == 0) return root.val;
        int right = traverse(root, --cnt[0]);

        return left == -1 ? right : left;
    }
}
*/


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