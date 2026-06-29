
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        traverse(root, map);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue() );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) pq.offer(entry);

        Map.Entry<Integer, Integer> mostFrequentEntry = pq.poll();
        int maxFrequency = mostFrequentEntry.getValue();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(mostFrequentEntry.getKey());
        
        while(!pq.isEmpty() && pq.peek().getValue() == maxFrequency){
            // System.out.println(pq.peek().getKey() + " " + pq.peek().getValue());
            list.add(pq.peek().getKey());
            pq.poll();
        }

        return list.stream().mapToInt(x -> x).toArray();
    }

    private int traverse(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return 0;

        int left = traverse(root.left, map);
        int right = traverse(root.right, map);

        int subTreeSum = left + right + root.val;
        map.put(subTreeSum, map.getOrDefault(subTreeSum, 0)+1);

        return subTreeSum;
    }
}