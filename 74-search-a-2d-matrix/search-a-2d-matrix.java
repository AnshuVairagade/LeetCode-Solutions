// Hint : BS on 1D array of size m*n

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;
        
        int low = 0, high = m*n - 1;
        while(low <= high){
            int mid = (low + high);
            int r = mid/n, c = mid%n;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) high = mid-1;
            else low = mid + 1;
        }

        return false;
    }
}