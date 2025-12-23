 
class Solution {
    int mod = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return countPaths(grid, 0, 0, 0, k, dp);
    }

    private int countPaths(int[][] grid, int r, int c, int pathSum, int k, int[][][] dp){
        
        if(r>= grid.length || c>=grid[0].length){
            return 0;
        }

        pathSum = pathSum+grid[r][c];
        int p = pathSum%k;

        if(dp[r][c][p] != -1) return dp[r][c][p];

        if(r == grid.length-1 && c == grid[0].length-1){
            if(pathSum % k == 0) return 1; 
            return 0;
        }

        int down = countPaths(grid, r+1, c, p, k, dp);
        int right = countPaths(grid, r, c+1, p, k, dp);

        int cnt = (down + right)%mod;
        return dp[r][c][p] = cnt;
    }
}


/*

Look at previous submission for clarity

Using int[][][] dp is good as compared to string as both has O(m*n*k) time and space complexity and string collision checking overhead is extra
*/



