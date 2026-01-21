class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            Long sum = 0L;

            for(int i=0;i<cnt; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            minHeap.offer(sum);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        return minHeap.size() == k ? minHeap.poll() : -1;
    }
}

/*
TC = O(n * k * log(k))
SC = O(n + k)
*/