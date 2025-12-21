class Solution {
    public int minOperations(int[] nums, int k) {
        int cnt = 0;

        for(int num : nums){
            if(num < k) cnt++;
        }

        return cnt;
    }
}

/*

1) Binary Search: (Better)
---------------------
nums[i] >= k => lower bound condition
TC = O(n * log(n)) + O(log(n))
SC = O(1)

2) Iterative Solution (Optimal)
----------------------
cnt elements lesser than k
TC = O(N)
SC = O(1)

*/ 