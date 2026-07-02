class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        traverse(root, parentMap, queue, start);

        int time = -1;
        while(!queue.isEmpty()){
            int n = queue.size();
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                set.add(node);
                sb.append(node.val).append(" ");

                if(node.left != null && !set.contains(node.left)){
                    queue.offer(node.left);
                }
                if(node.right != null && !set.contains(node.right)){
                    queue.offer(node.right);
                }
                // bfs critical section
                if(parentMap.containsKey(node) && !set.contains(parentMap.get(node))){
                    queue.offer(parentMap.get(node));
                }
            }

            System.out.println(sb);

            time++;
        }

        return time;
    }

    private void traverse(TreeNode root, HashMap<TreeNode, TreeNode> parentMap, Queue<TreeNode> queue, int start){
        if(root == null) return;

        if(root.val == start){
            queue.offer(root);
        }

        if(root.left != null){
            parentMap.put(root.left, root);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
        }

        traverse(root.left, parentMap, queue, start);
        traverse(root.right, parentMap, queue, start);
    }
}