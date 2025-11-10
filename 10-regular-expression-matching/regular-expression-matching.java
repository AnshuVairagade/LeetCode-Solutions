// Tabulation

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[m][n];
    }
}


/* Memoization 

class Solution {
    private boolean solve(int i, int j, String s, String p){
        if(j<0 && i<0){
            return true;
        }
        if(j<0 && i>0) return false;
        if(i < 0 && j>0){
            for(int k=0; k<=j; k++){
                if(p.charAt(j) != '*') return false;
            }
            return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            return solve(i-1, j-1, s, p);
        }
        else if(p.charAt(i) == '*'){
            return solve(i, j-1, s, p) || solve(i-1, j, s, p);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return solve(m-1, n-1, s, p);
    }
}
*/ 


/* DP Solution

https://leetcode.com/problems/regular-expression-matching/solutions/5651/easy-dp-java-solution-with-detailed-explanation/

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m+1][n+1];

        for(int j=1; j<=n; j++){
            if(p.charAt(j-1) == '*' && dp[0][j-2]) dp[0][j] = true;
        }
        dp[0][0] = true;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '*'){
                    if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    }
                    else dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
*/
