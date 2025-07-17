class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int maxIdx = -1;

        int dp[][] = new int[n][n];

        for(int diff=0; diff<n; diff++){ // Intermediate substring
            for(int i=0, j=i+diff; j<n; i++, j++){ 
                // i = start and j = end of string
                if(i==j) dp[i][j] = 1;
                else if(diff == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j))?2:0;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] != 0){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                }

                if(dp[i][j] > 0 && maxLen < j-i+1){
                    maxIdx = i; maxLen = j-i+1;
                }
            }
        }
        if(maxIdx == -1) return "";
        return s.substring(maxIdx, maxIdx+maxLen);
    }
}


/* Brute Force => O(N*N*N) => TLE

class Solution {
    public boolean isPalindrome(String t){
        StringBuilder sb = new StringBuilder(t);
        String p = sb.reverse().toString();
        if(t.equals(p)) return true;
        return false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int maxIdx = -1;

        for(int i=0; i<n; i++){
            StringBuilder t = new StringBuilder();
            for(int j=i; j<n; j++){
                t.append(s.charAt(j));
                if(maxLen < t.length() && isPalindrome(t.toString())){
                    maxLen = t.length();
                    maxIdx = i;
                }
            }
        }
        if(maxIdx == -1) return "";
        return s.substring(maxIdx, maxIdx+maxLen);
    }
}

*/