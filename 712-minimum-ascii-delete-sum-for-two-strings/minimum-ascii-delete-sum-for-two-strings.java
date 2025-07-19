class Solution {
    private int lcs(String s, String t){
        int m = s.length();
        int n = t.length();
        int prev[] = new int[n+1];

        for(int i=1; i<=m; i++){
            int curr[] = new int[n+1];
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = s.charAt(i-1) + prev[j-1];
                }
                else curr[j] = Math.max(curr[j-1], prev[j]);
            }
            prev = curr;
        }

        return prev[n];
    }

    public int minimumDeleteSum(String s1, String s2) {
        int sum = 0;
        for(char ch : s1.toCharArray()) sum += ch;
        for(char ch : s2.toCharArray()) sum += ch;

        int lcsSum = lcs(s1, s2);
        return sum - 2*lcsSum;
    }
}