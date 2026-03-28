// How to handle overflow
// how r and c is calculated

class Solution {
    int mod = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long[] leftProd = new long[m*n];
        long[] rightProd = new long[m*n];

        leftProd[0] = 1;
        for(int i=1; i<m*n; i++){
            int r = (i-1)/n;
            int c = (i-1)%n;

            leftProd[i] = (leftProd[i-1] * grid[r][c])%mod;
        }

        rightProd[m*n-1] = 1;
        for(int i=m*n-2; i>=0; i--){
            int r = (i+1)/n;
            int c = (i+1)%n;

            rightProd[i] = (rightProd[i+1] * grid[r][c])%mod;
        }

        for(int i=0; i<m*n; i++){
            int r = i/n;
            int c = i%n;
            grid[r][c] = (int)((leftProd[i] * rightProd[i])%mod);
        }

        return grid;
    }
}