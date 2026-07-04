class Solution {
    public Node connect(Node root) {
        build(root);
        return root;
    }

/*     Intuition : See comment with image    

        Use the top-down approach :
            
        For every node:
                    -> root.left.next = right
                    -> root.right.next = right subtree left 


        Use previously built next pointer
*/


    private void build(Node root){
        if(root == null || (root.left == null && root.right == null)) return;

        root.left.next = root.right;
        root.right.next = root.next != null ? root.next.left : null;

        build(root.left);
        build(root.right);
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/