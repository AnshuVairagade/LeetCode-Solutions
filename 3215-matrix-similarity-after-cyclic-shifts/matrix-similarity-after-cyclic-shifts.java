class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // main logic
                if(mat[i][j] != mat[i][(j+k)%n]) return false;
            }
        }

        return true;
    }
}

/* Intuition:
---------------
If after rotating the matrix we are supposed to get same value at index cyclically 
then why to rotate rows????
Directly check mat[i][j] != mat[i][(j+k)%n] as shifted index will have same value
*/