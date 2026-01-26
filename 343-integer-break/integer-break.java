// Documentation given below

class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, 0, dp);
    }

    private int helper(int n, int cnt, int[] dp){
        if(n == 0 && cnt >= 2){
            return 1;
        }
        if(dp[n] != -1) return dp[n];

        int res = 1;
        for(int i=1; i<=n; i++){
            if(cnt < 2 && i == n) continue;
            int val = i * helper(n-i, cnt+1, dp);
            res = Math.max(val, res);
        }

        return dp[n] = res;
    }
}

/*
To unserstand the intuition draw thee recursion tree, as similar to 279. Perfect Squares

*/