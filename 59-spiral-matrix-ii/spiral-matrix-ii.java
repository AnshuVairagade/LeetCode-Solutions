class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];

        int top = 0, bottom = n-1;
        int left = 0, right = n-1;
        int val = 1;
        while(top<=bottom && left <= right){
            // Top row Traversal
            for(int j=left; j<=right; j++){
                mat[top][j] = val++;
            }
            top++;

            // Right column Traversal
            for(int i=top; i<=bottom; i++){
                mat[i][right] = val++;
            }
            right--;
            
            // Bottom Row Traversal
            if(top <= bottom){
                for(int j=right; j>=left; j--){
                    mat[bottom][j] = val++;
                }
                bottom--;
            }

            // Left Column Traversal
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    mat[i][left] = val++;
                }
                left++;
            }
        }
        
        return mat;
    }
}