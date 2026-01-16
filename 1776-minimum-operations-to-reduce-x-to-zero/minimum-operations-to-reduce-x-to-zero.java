// Bug is given below

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }

        if(totalSum == x) return nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int currSum = 0;
        int maxLen = -1;
        int sum = totalSum - x;

        for(int i=0; i<n; i++){
            currSum += nums[i];

            int remSum = currSum - sum;
            if(map.containsKey(remSum)){
                int idx = map.get(remSum);
                maxLen = Math.max(maxLen, i-idx);
            }

            map.put(currSum, i);
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}


/*

Solution : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/solutions/935935/java-detailed-explanation-on-prefix-summ-hdew


See previous attemp for wrong approach

 */