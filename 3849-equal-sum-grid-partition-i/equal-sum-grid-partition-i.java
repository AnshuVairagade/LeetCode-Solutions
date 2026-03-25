// Bug in previous code
// Overflow due to constraints

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;   

        long pmat[][] = prefixMatrix(grid, m, n);

        for(int i=1; i<m; i++){
            if((pmat[m-1][n-1] - pmat[i-1][n-1]) == pmat[i-1][n-1]){
                return true;
            }
        }

        for(int j=1; j<n; j++){
            if((pmat[m-1][n-1] - pmat[m-1][j-1]) == pmat[m-1][j-1]){
                return true;
            }
        }

        return false;     
    }

    private long[][] prefixMatrix(int[][] mat, int m, int n){
        long[][] pmat = new long[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                long up = i>0 ? pmat[i-1][j] : 0;
                long left = j>0 ? pmat[i][j-1] : 0;
                long dig = i>0 && j>0 ? pmat[i-1][j-1] : 0;

                pmat[i][j] = (long)mat[i][j] + up + left - dig;
            }
        }

        return pmat;
    }
}


/*
Debugging Helper:

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(pmat[i][j]+" ");
            }
            System.out.println();
        }

*/