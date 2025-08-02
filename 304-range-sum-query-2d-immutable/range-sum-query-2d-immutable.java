// Using Row and Column Prefix Sum

class NumMatrix {
    int prefix[][];

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m][n];

        for(int i=0; i<m; i++){
            prefix[i][0] = matrix[i][0];
            for(int j=1; j<n; j++){
                prefix[i][j] = matrix[i][j] + prefix[i][j-1];
            }
        }

        for(int j=0; j<n; j++){
            for(int i=1; i<m; i++){
                prefix[i][j] += prefix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum += prefix[row2][col2];
        sum -= (row1 > 0) ? prefix[row1-1][col2] : 0;
        sum -= (col1 > 0) ? prefix[row2][col1-1] : 0;
        sum += (row1 > 0 && col1 > 0) ? prefix[row1-1][col1-1] : 0; 
        return sum;
    }
}


/* Using the Row Prefix Sum 

class NumMatrix {
    int prefix[][];

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m][n];

        for(int i=0; i<m; i++){
            prefix[i][0] = matrix[i][0];
            for(int j=1; j<n; j++){
                prefix[i][j] = matrix[i][j] + prefix[i][j-1];
            }
        }

        for(int i=0; i<n; i++){
            for(int i=1; j<m; j++){
                prefix[i][j] += prefix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++){
            sum += (prefix[i][col2] - ((col1 > 0) ? prefix[i][col1-1] : 0));
        }
        return sum;
    }
}

TC : O(N) for sum()
*/

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */