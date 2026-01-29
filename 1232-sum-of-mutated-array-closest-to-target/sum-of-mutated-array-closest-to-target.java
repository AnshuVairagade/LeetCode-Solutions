class Solution {
    public int findBestValue(int[] nums, int target) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 0, high = max;
        while(low <= high){
            int mid = low + (high-low)/2;

            // Fixed Approach using Converge Function
            int diff_x = helper(nums, mid, target); 
            int diff_fx = helper(nums, mid+1, target); 
            
            if(diff_x <= diff_fx){
                high = mid - 1;
            }
            else low = mid+1;
        }
    
        return low;
    }

    private int helper(int[] nums, int val, int target){
        int sum = 0;
        for(int num : nums){
            sum += Math.min(num, val);
        }
        return Math.abs(sum - target);
    }
}

/* 
Unserstand why we used Converger Function

Similar Problem: 
https://leetcode.com/problems/minimum-cost-to-make-array-equal/description/

*/