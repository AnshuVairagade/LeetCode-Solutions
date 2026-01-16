class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = 1L * n * (n-1) /2;

        HashMap<Integer, Long> map = new HashMap<>();
        long goodPairs = 0;

        for(int i=0; i<n; i++){
            int diff = nums[i] - i;
            
            long prev = map.getOrDefault(diff, 0L);
            goodPairs += prev;

            map.put(diff, map.getOrDefault(diff, 0L)+1);
        }

        return totalPairs - goodPairs;
    }
}


/*
Solution : https://leetcode.com/problems/count-number-of-bad-pairs/solutions/6395796/mathematical-explanation-example-walkthr-01im

*/