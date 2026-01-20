class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int er = m - 3;
        int ec = n - 3;

        int maxSum = 0;
        for(int i=0; i<=er; i++){
            for(int j=0; j<=ec; j++){
                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j+1] 
                        + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];

                maxSum = Math.max(sum, maxSum);
            }
        } 

        return maxSum;
    }
}