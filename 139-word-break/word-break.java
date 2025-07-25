class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);

        boolean dp[] = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                String t = s.substring(i, j+1);
                if(set.contains(t) && dp[j+1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}