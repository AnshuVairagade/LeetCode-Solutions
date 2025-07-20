class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dp[][] = new int[n+1][2];
        dp[n][0] = 0; dp[n][1] = 0;

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<2; j++){
                int profit = 0;

                if(j==1){ // You can buy the stock
                    int include = -prices[i] + dp[i+1][0];
                    int exclude = 0 + dp[i+1][1];
                    profit = Math.max(include, exclude);
                }
                else{ // You can sell the stock
                    int include = prices[i] + dp[i+1][1] - fee;
                    int exclude = 0 + dp[i+1][0];
                    profit = Math.max(include, exclude);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }

}


/* Base case for memoization
if(day == n) return 0  => Cannot perform operation as days are ended 
*/ 