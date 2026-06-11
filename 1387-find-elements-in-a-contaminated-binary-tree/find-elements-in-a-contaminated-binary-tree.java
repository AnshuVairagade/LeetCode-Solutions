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
class FindElements {
    HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        
        root.val = 0;
        set.add(0);
        build(root);
        
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void build(TreeNode node){
        if(node.left != null){
            int data = node.val * 2 + 1;
            set.add(data);
            node.left.val = data; 
            build(node.left);
        }
        if(node.right != null){
            int data = node.val * 2 + 2;
            set.add(data);
            node.right.val = data;
            build(node.right);
        }
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */