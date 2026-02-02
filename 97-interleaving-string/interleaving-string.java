/*
TLE due to using boolean[][][] dp
Use Boolean[][][] dp for safer conditions

Boolean is preferred over boolean in memoization because it can represent three states, while boolean can represent only two.

For DP or memoized recursion, every state must be in one of these three states:

1) Not computed yet
2) Computed and result is true
3) Computed and result is false

This distinction is absolutely critical.
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean dp[][] = new Boolean[s1.length()+1][s2.length()+1];
        return checkInterleaving(0, 0, 0, s1, s2, s3, dp);
    }

    private boolean checkInterleaving(int i, int j, int k , String s1, String s2, String s3, Boolean dp[][]){
        if(k == s3.length()){
            if(i==s1.length() && j==s2.length()) return true;
            return false;
        }

        if(dp[i][j] != null) return dp[i][j]; 

        boolean flag = false;
        if(i<s1.length() && j<s2.length() && 
        s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            boolean op1 = checkInterleaving(i+1, j, k+1, s1, s2, s3, dp);
            boolean op2 = checkInterleaving(i, j+1, k+1, s1, s2, s3, dp);
            flag = op1 || op2;
        }
        else if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            flag = checkInterleaving(i+1, j, k+1, s1, s2, s3, dp);
        }
        else if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            flag = checkInterleaving(i, j+1, k+1, s1, s2, s3, dp);
        }

        return dp[i][j] = flag;
    }
}

