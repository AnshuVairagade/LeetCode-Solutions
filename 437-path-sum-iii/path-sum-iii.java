class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L ,1);
        return cntPaths(root, 0L, targetSum, map);
    }

    private int cntPaths(TreeNode root, Long currSum, int target, HashMap<Long, Integer> map){
        if(root == null) return 0;

        currSum += root.val;
        int cnt = map.getOrDefault(currSum - target, 0);

        map.put(currSum, map.getOrDefault(currSum, 0)+1);

        int leftPaths = cntPaths(root.left, currSum, target, map);
        int rightPaths = cntPaths(root.right, currSum, target, map);

        map.put(currSum, map.get(currSum)-1);
        
        return cnt + rightPaths + leftPaths;
    }    
}


/* Brute force approach

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return generatePaths(root, targetSum);
    }

    private int generatePaths(TreeNode root, int k){
        if(root == null) return 0;

        int curr = calculatePathSum(root, k);
        int leftPaths = generatePaths(root.left, k);
        int rightPaths = generatePaths(root.right, k);

        return curr + leftPaths + rightPaths;
    }

    //  k = targetSum
    private int calculatePathSum(TreeNode root, int k){
        if(root == null) return 0;
        
        int cnt = 0;
        if(root.val == k) cnt++;

        int leftPaths = calculatePathSum(root.left, k-root.val);
        int rightPaths = calculatePathSum(root.right, k-root.val);

        return cnt + leftPaths + rightPaths;
    }
}

*/


/*
To generate all possible pats:
    1) Pick node to calculate paths starting from it
    2) Not-Pick to calculate paths starting from its children
 
 
To calculate sum:
    1) Check for path ending at current node
    2) Calculate path sum for which current is part
 */


// Solution : https://www.youtube.com/watch?v=uZzvivFkgtM