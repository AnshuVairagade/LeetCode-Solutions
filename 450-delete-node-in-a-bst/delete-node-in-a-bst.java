/*  https://www.youtube.com/watch?v=NL1ocKYzlAM 

    To overcome previous bug, update root.left with new left after deletion.

*/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val == key){
            if(root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }

            int leftMax = findLeftMax(root.left);
            root.left = deleteNode(root.left, leftMax);
            root.val = leftMax;
            return root;
        }
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private int findLeftMax(TreeNode root){
        if(root.right == null){
            return root.val;
        }

        return findLeftMax(root.right);
    }
}