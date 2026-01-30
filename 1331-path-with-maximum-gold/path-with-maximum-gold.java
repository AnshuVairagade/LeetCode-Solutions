class Solution {
    int dir[] = {-1, 0, 1, 0, -1};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // int vis[][] = new int[m][n];

        int maxGold = 0;
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                System.out.println();
                maxGold = Math.max(maxGold, dfs(i, j, grid));
            }
        }

        return maxGold;
    }

    private int dfs(int r, int c, int grid[][]){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length){
            return 0;
        }
        
        if(grid[r][c] == 0) return 0;
        int currGoldAmt = grid[r][c];
        grid[r][c] = 0;

        int maxGold = 0;
        for(int d=0; d<4; d++){
            int nr = r + dir[d];
            int nc = c + dir[d+1];
            
            maxGold = Math.max(maxGold, dfs(nr, nc, grid));
        }
 
        grid[r][c] = currGoldAmt;

        
        return maxGold + currGoldAmt;
    }
}