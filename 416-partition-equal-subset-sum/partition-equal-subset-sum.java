class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum%2 != 0) return false;
        int target = sum/2;
        Boolean dp[][] = new Boolean[n][target+1];
        return tabulation(target, nums, dp);
        // return solve(n-1, nums, target, dp);
    }


    private boolean tabulation(int target, int nums[], Boolean dp[][]){
        if(target == 0) return true;
        int n = nums.length;
        for(int idx=0; idx<n; idx++) dp[idx][0] = true;
        for(int t=0; t<=target; t++) dp[0][t] = false;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int idx=1; idx<n; idx++){
            for(int t=1; t<=target; t++){
                boolean notpick = dp[idx-1][t];
                boolean pick = false;
                if(nums[idx] <= t) pick = dp[idx-1][t-nums[idx]];
                dp[idx][t] = pick || notpick;
            }
        }

        return dp[n-1][target];
    }


    // Memoization
    private boolean solve(int idx, int nums[], int target, Boolean dp[][]){
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;
        if(dp[idx][target] != null) return dp[idx][target];

        boolean notpick = solve(idx-1, nums, target, dp);
        boolean pick = false;
        if(nums[idx] <= target) pick = solve(idx-1, nums, target-nums[idx], dp);

        return dp[idx][target] = pick || notpick;
    }
}