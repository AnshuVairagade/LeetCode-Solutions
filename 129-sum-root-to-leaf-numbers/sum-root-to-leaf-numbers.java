class Solution {
    public int sumNumbers(TreeNode root) {
        int res[] = new int[1];

        traverse(root, 0, res);
        
        return res[0];
    }

    private void traverse(TreeNode root, int prev, int[] res){
        if(root.left  == null && root.right == null){
            int curr = prev*10 + root.val;
            res[0] += curr;
            return;
        }

        int curr = prev*10 + root.val;
        if(root.left != null) traverse(root.left, curr, res);
        if(root.right != null) traverse(root.right, curr, res);
    }
}


/*
Recurse down the tree and build numbers; 
store them into list to sum as answer

class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        int res[] = new int[1];
        traverse(root, nums, 0, res);

        int sum = 0;
        for(int num : nums) sum += num;

        // return sum;
        return res[0];
    }

    private void traverse(TreeNode root, List<Integer> nums, int prev, int[] res){
        if(root.left  == null && root.right == null){
            int curr = prev*10 + root.val;
            nums.add(curr);
            res[0] += curr;
            return;
        }

        int curr = prev*10 + root.val;
        if(root.left != null) traverse(root.left, nums, curr, res);
        if(root.right != null) traverse(root.right, nums, curr, res);
    }
}


 */