// generate the DP matrix for the palindromic substring and count of dp[i][j] > 0 is the nuber of distinct palindromic substring

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        
        int cnt = 0;
        for(int diff=0; diff<n; diff++){
            for(int i=0, j=diff; j<n; i++, j++){
                if(diff == 0){
                    cnt++; dp[i][j] = 1;
                }
                else if(diff == 1 && s.charAt(i) == s.charAt(j)){
                    cnt++; dp[i][j] = 2;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]>0){
                    cnt++; dp[i][j] = 2 + dp[i+1][j-1];
                }
            }
        }

        return cnt;
    }
}