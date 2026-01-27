class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Long, Integer> map = new HashMap<>();
        int n = nums.length;

        long sum = 0;
        for(int num : nums) sum += num;

        long k = sum % p;
        if(k == 0) return 0;

        map.put(0L, -1);
        int len = n;
        sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + nums[i];

            long r1 = sum % p;
            long r2 = (r1 - k + p) % p;

            if(map.containsKey(r2)){
                len = Math.min(len, i - map.get(r2));
            }

            map.put(r1, i);
        }

        return len == n ? -1 : len;
    }
}

/*
Intuition:
Why sliding window fails???
If not sliding window then prefix sum


Approach:
For visual go to google drive : 


Similar problem : https://leetcode.com/problems/count-of-interesting-subarrays/
Solution : https://www.youtube.com/watch?v=MTQWe8qHcz0

*/


