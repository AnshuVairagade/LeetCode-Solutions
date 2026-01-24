// Code Documentation

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);
        int n = s.length();

        boolean dp[] = new boolean[s.length()+1];
        dp[n] = true;

        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<=s.length(); j++){
                String prefix = s.substring(i, j);

                if(set.contains(prefix) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}

/*
1) Why 1D DP  -> only { i } is used 
2) Write break for early return of recursion 
3) Visualize the recursion tree for TC and SC
*/


/* Tabulation:
---------------

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);

        boolean dp[] = new boolean[s.length()];

        return breakWord(0, s, set, dp);
    }

    private boolean breakWord(int i, String s, HashSet<String> set, boolean dp[]){
        if(i == s.length()){
            return true;
        }

        if(dp[i]) return true;

        for(int j=i+1; j<=s.length(); j++){
            String prefix = s.substring(i, j);

            if(set.contains(prefix) && breakWord(j, s, set, dp)){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}

*/

/* 
Wrong Memoization:
--------------------

Subproblem depen on i not prefix or suffic string
As i is only changing parameter we use 1D dp[n];

I am storing prefix from s[i...j] to check overlapping subproblem but
Here overlapping subproblem depends on the index 
So we get s[j...n-1] is valid word break


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);

        HashMap<String, Boolean> map = new HashMap<>();

        return breakWord(0, s, set, map);
    }

    private boolean breakWord(int i, String s, HashSet<String> set, HashMap<String, Boolean> map){
        if(i == s.length()){
            return true;
        }

        if(map.containsKey(s)) return map.get(s);

        for(int j=i+1; j<=s.length(); j++){
            String prefix = s.substring(i, j);

            if(set.contains(prefix) && breakWord(j, s, set, map)){
                map.put(s, true);
                return true;
            }
        }

        map.put(s, false);
        return false;
    }
}

*/