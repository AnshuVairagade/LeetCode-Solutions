class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        
        int[][] row = new int[m + 2][n + 2];
        int[][] col = new int[m + 2][n + 2];
        int[][] diag = new int[m + 2][n + 2];
        int[][] antiD = new int[m + 2][n + 2];
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                row[i][j] += grid[i - 1][j - 1] + row[i][j - 1];
                col[i][j] += grid[i - 1][j - 1] + col[i - 1][j];
                diag[i][j] += grid[i - 1][j - 1] + diag[i - 1][j - 1];
                antiD[i][j] += grid[i - 1][j - 1] + antiD[i - 1][j + 1];
            }
        }
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int k = Math.min(m - i, n - j); k > res; --k) {
                    int sum = diag[i + k][j + k] - diag[i - 1][j - 1];
                    boolean match = sum == antiD[i + k][j] - antiD[i - 1][j + k + 1]; 
                    for (int l = 0; l <= k && match; ++l) {
                        match &= sum == row[i + l][j + k] - row[i + l][j - 1];
                        match &= sum == col[i + k][j + l] - col[i - 1][j + l];
                    }
                    if (match) {
                        res = k;
                        break;
                    }
                }
            }
        }
        return res + 1;
    }
}