class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int zrCnt[] = new int[m];
        int zcCnt[] = new int[n];
        int diff[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    zrCnt[i]++; zcCnt[j]++;
                }
            }
        }
    
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                diff[i][j] = (m+n) - 2*(zrCnt[i]+zcCnt[j]);
            }
        }

        return diff;
    }
}