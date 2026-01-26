// Code documentation given below

class Solution {
    int mod = (int)(1e9+7);

    public int numberOfWays(int n, int x) {
        int powers[] = new int[n+1];
        for(int i=0; i<=n; i++) powers[i] = pow(i, x);

        int dp[][] = new int[n+1][n+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        return helper(n, 0, x, dp, powers);
    }

    private int helper(int n, int prev, int x, int[][] dp, int[] powers){
        if(n == 0) return 1;

        if(dp[n][prev] != -1) return dp[n][prev];

        int cnt = 0;
        for(int i=prev+1; i<= n; i++){
            // int val = pow(i, x);
            if(powers[i] > n) break;

            cnt =  (cnt + helper(n-powers[i], i, x, dp, powers))%mod;
        }

        return dp[n][prev] = (cnt)%mod;
    }

    private int pow(int base, int exponent){
        int pow = 1;
        while(exponent > 0){
            pow = pow * base;
            exponent--;
        }
        return pow;
    }
}

/*
Intuition : Perfect Sqaure problem
Draw the recursion tree you will understand the dp pattern

Why 2D dp memoization??
What power can be deleted from the current number??

Approach : Understand the code 


*/