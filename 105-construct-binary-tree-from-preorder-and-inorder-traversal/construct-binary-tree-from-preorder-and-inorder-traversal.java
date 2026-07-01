class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, 0, inorder.length-1);
    }

    private TreeNode construct(int[] pre, int[] in, int curr, int left, int right){
        if(left > right) return null;

        TreeNode node = new TreeNode(pre[curr]);

        // Extra time ----> O(N) : search
        int index = search(in, pre[curr], left, right);

        node.left = construct(pre, in, curr+1, left, index-1);
        node.right = construct(pre, in, curr+index-left+1, index+1, right);

/*          left & right pointer -> inorder boundaries
            curr pointer         -> preorder boundaries             */

        return node;
    }


    /*

    Bug: Below Seacrh will only work for BST and input is BT.

    private int search(int[] arr, int k, int left, int right){
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] > k) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }

    */


    private int search(int[] arr, int k, int left, int right){
        for(int i=left; i<=right; i++){
            if(arr[i] == k) return i;
        }
        return -1;
    }
}


