class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int dp[][][] = new int[len+1][m+1][n+1];
        
        for(int idx = len-1; idx>=0; idx--){

            int zeros = 0, ones = 0;
            for(char dig : strs[idx].toCharArray()){
                if(dig == '1') ones++;
                else zeros++;
            }

            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++){

                    int nopick = dp[idx+1][j][k];

                    int pick = 0;
                    if(zeros <= j && ones <= k){
                        pick = 1 + dp[idx+1][j-zeros][k-ones];
                    }

                    dp[idx][j][k] = Math.max(pick, nopick);
                }
            }
        }

        return dp[0][m][n];
    }

}

