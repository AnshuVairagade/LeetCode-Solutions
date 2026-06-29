// Optimizing O(nlogn) -> O(n) 

class Solution {
    int maxFrequency = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        traverse(root, map);

        List<Integer> list = new ArrayList<>();
        for(int subTreeSum : map.keySet()){
            if(map.get(subTreeSum) == maxFrequency){
                list.add(subTreeSum);
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }

    private int traverse(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return 0;

        int left = traverse(root.left, map);
        int right = traverse(root.right, map);

        int subTreeSum = left + right + root.val;
        map.put(subTreeSum, map.getOrDefault(subTreeSum, 0)+1);

        maxFrequency = Math.max(maxFrequency, map.get(subTreeSum));

        return subTreeSum;
    }
}