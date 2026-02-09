class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length][m+1][n+1];
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++) dp[i][j][k] = -1;
            }
        }

        int temp = helper(0, m, n, strs, dp);  
        return temp;
    }

    private int helper(int idx, int m, int n, String[] strs, int[][][] dp){
        // Bug point removed

        if(idx == strs.length){
            return 0;
        }

        if(dp[idx][m][n] != -1) return dp[idx][m][n];

        int zeros = 0, ones = 0;
        for(char dig : strs[idx].toCharArray()){
            if(dig == '1') ones++;
            else zeros++;
        }

        int nopick = helper(idx+1, m, n, strs, dp);

        int pick = 0;
        if(zeros <= m && ones <= n){
            pick = 1 + helper(idx+1, m-zeros, n-ones, strs, dp);
        }

        return dp[idx][m][n] = Math.max(pick, nopick);
    }
}


/*


class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public int findMaxForm(String[] strs, int m, int n) {
        List<String> list = new ArrayList<>();
        int temp = helper(0, m, n, strs, list);        
        System.out.println(res);
        return temp;
    }

    private int helper(int idx, int m, int n, String[] strs, List<String> list){
        if(m<=0 || n<=0){
            res.add(new ArrayList<>(list));
            return 0;
        }

        if(idx == strs.length){
            res.add(new ArrayList<>(list));
            return 0;
        }

        int zeros = 0, ones = 0;
        for(char dig : strs[idx].toCharArray()){
            if(dig == '1') ones++;
            else zeros++;
        }

        int nopick = helper(idx+1, m, n, strs, list);

        int pick = 0;
        if(zeros <= n && ones <= m){
            list.add(strs[idx]);
            pick = 1 + helper(idx+1, m-zeros, n-ones, strs, list);
            list.remove(list.size()-1);
        }

        return Math.max(pick, nopick);
    }
}


*/