class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        int minLevel = 0, level = 0;
        int maxSum = Integer.MIN_VALUE;

        queue.offer(root);
        while(!queue.isEmpty()){
            level++;
            int sum = 0;

            int n = queue.size(); // fixed queue length
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                minLevel = level;
            }
        }
        
        return minLevel;
    }
}