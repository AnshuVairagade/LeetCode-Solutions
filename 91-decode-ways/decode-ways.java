// Space optimization
class Solution{
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.charAt(0)=='0') return 0;

        int prev2 = 1, prev = 1;
        for(int i=2; i<=n; i++){
            int curr=0;
            char ch = s.charAt(i-1);
            char pch = s.charAt(i-2);
            if(ch>='1' && ch<='9'){
                curr = prev;
            }
            if((pch == '1') || (pch == '2' &&  ch>='0' && ch<='6')){
                curr += prev2;
            }
            prev2 = prev;
            prev = curr;

            if(curr == 0) return 0;;
        }

        return prev;
    }
}



/* Tabulation 
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.charAt(0)=='0') return 0;

        int dp[] = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for(int i=2; i<=n; i++){
            char ch = s.charAt(i-1);
            char pch = s.charAt(i-2);
            if(ch>='1' && ch<='9'){
                dp[i] = dp[i-1];
            }
            if(pch == '1'){
                dp[i] += dp[i-2];
            }
            if(pch == '2' && ch>='0' && ch<='6'){
                dp[i] += dp[i-2];
            }
        }       
        return dp[n];
    }
}
*/

// Code for memoization and Recursion is in codolio notes