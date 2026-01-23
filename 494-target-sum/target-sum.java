class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n+1][2001];
        for(int row[] : dp) Arrays.fill(row, -1);

        return build(0, 0, nums, target, dp);
    }

    private int build(int i, int sum, int[] nums, int k, int[][] dp){
        if(i == nums.length){
            if(sum == k) return 1;
            return 0;
        } 

        if(dp[i][sum+1000] != -1) return dp[i][sum+1000];

        int add = build(i+1, sum+nums[i], nums, k, dp);
        int sub = build(i+1, sum-nums[i], nums, k, dp);

        return dp[i][sum+1000] = add + sub;
    }
}

/*

Why index shifting???
range of the target

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n+1][2001];
        for(int row[] : dp) Arrays.fill(row, -1);

        return build(0, 0, nums, target, dp);
    }

    private int build(int i, int sum, int[] nums, int k, int[][] dp){
        if(i == nums.length){
            if(sum == k) return 1;
            return 0;
        } 

        if(dp[i][sum+1000] != -1) return dp[i][sum+1000];

        int add = build(i+1, sum+nums[i], nums, k, dp);
        int sub = build(i+1, sum-nums[i], nums, k, dp);

        return dp[i][sum+1000] = add + sub;
    }
}

*/