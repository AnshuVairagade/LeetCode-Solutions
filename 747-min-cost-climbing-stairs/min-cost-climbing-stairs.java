// Tabulation

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = cost[1];
        int prev2 = cost[0];

        for(int i=2; i<n; i++){
            int curr = cost[i] + Math.min(prev, prev2);
            prev2 = prev;
            prev = curr;
        }

        return Math.min(prev, prev2);  // return Math.min(dp[n-1], dp[n-2]);
    }
}


/* Memoization + Recursion Base

class Solution {
    private int solve(int idx, int[] cost, int[] dp){
        if(idx < 0) return 0;
        if(idx == 0 || idx == 1) return cost[idx];
        if(dp[idx] != -1) return dp[idx];

        int oneStep = solve(idx-1, cost, dp);
        int twoStep = solve(idx-2, cost, dp);

        return dp[idx] = cost[idx] + Math.min(oneStep, twoStep);
    }   

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int a = solve(n-1, cost, dp);
        Arrays.fill(dp, -1);
        int b = solve(n-2, cost, dp);

        return Math.min(a,b);
    }
}

*/