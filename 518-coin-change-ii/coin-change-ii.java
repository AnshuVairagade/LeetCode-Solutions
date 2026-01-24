// Using subsequence DP

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int prev[] = new int[amount+1];
        prev[0] = 1;

        for(int i=n-1; i>=0; i--){
            int[] curr = new int[amount+1];
            curr[0] = 1;

            for(int amt=1; amt<=amount; amt++){
                int notpick = prev[amt];

                int pick = 0;
                if(coins[i] <= amt) {
                    pick = curr[amt-coins[i]];
                }

                curr[amt] = pick + notpick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}

/*

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int dp[][] = new int[n+1][amount+1];

        for(int i=0; i<=n; i++) dp[i][0] = 1;
        for(int j=1; j<=amount; j++) dp[n][j] = 0;

        for(int i=n-1; i>=0; i--){
            for(int amt=1; amt<=amount; amt++){
                int notpick = dp[i+1][amt];

                int pick = 0;
                if(coins[i] <= amt) {
                    pick = dp[i][amt-coins[i]];
                }

                dp[i][amt] = pick + notpick;
            }
        }

        return dp[0][amount];
    }
}

*/

/*

Recursion + Memoization
------------------------

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int dp[][] = new int[n][amount+1];
        for(int row[] : dp) Arrays.fill(row, -1);

        return helper(amount, 0, coins, dp);
    }

    private int helper(int amt, int i, int[] coins, int[][] dp){
        if(amt == 0) return 1;

        if(i == coins.length){
            if(amt == 0) return 1;
            return 0;
        }

        if(dp[i][amt] != -1) return dp[i][amt];

        int notpick = helper(amt, i+1, coins, dp);
        int pick = 0;
        if(coins[i] <= amt) {
            pick = helper(amt-coins[i], i, coins, dp);
        }

        return dp[i][amt] = pick + notpick;
    }
}


*/