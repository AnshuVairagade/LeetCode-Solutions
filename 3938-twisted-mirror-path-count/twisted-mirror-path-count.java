class Solution {
    int mod = (int)(1e9+7);

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j][0] = -1; dp[i][j][1] = -1;
            }
        }

        // return tabulation(grid);
        return memoization(0, 0, 0, grid, dp);
    }

    private int memoization(int r, int c, int dir, int grid[][], int dp[][][]){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length){
            return 0;
        }

        if(r == grid.length-1 && c == grid[0].length-1){
            return 1;
        }

        if(dp[r][c][dir] != -1) return dp[r][c][dir];

        if(grid[r][c] == 1){
            if(dir == 0) return dp[r][c][dir] = memoization(r+1, c, 1, grid, dp);
            else return dp[r][c][dir] = memoization(r, c+1, 0, grid, dp);
        }

        int right = memoization(r, c+1, 0, grid, dp);
        int down = memoization(r+1, c, 1, grid, dp);

        int count = (right + down)%mod;
        return dp[r][c][dir] = count;
    }


    private int tabulation(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m+1][n+1][2];

        // Base condition
        dp[m-1][n-1][0] = 1; dp[m-1][n-1][1] = 1;

        for(int r=m-1; r>=0; r--){
            for(int c=n-1; c>=0; c--){
                if(r == m-1 && c == n-1) continue;
                for(int dir=0; dir<=1; dir++){
                    if(grid[r][c] == 1){
                        if(dir == 0) dp[r][c][dir] = dp[r+1][c][0];
                        else dp[r][c][dir] = dp[r][c+1][1];
                    }
                    else{  
                        int right = dp[r][c+1][0];
                        int down = dp[r+1][c][1];

                        int count = (right + down)%mod;
                        dp[r][c][dir] = count;
                    }
                }
            }
        }

        return dp[0][0][0];
    }

    
}

// Recursion TC =  TC = O(2^(m+n))