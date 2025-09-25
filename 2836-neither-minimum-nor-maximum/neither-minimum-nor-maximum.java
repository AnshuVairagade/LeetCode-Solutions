class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;

        // // Approach 1 -> O(NlogN)
        // Arrays.sort(nums);
        // return nums[1];

        // Approach 2 -> O(N+N)
        int min=101, max=-1;
        for(int i=0; i<n; i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        int ans = -1;
        for(int i=0; i<n; i++){
            if(nums[i]!=max && nums[i]!=min) return nums[i];
        }

        return ans;
    }
}