//  90 degree rotation = Transpose + row reverse
// 180 degree rotation = column reverse
// 270 degree rotation = Transpose
// 360 degree rotation = Transpose + Transpose


class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int cnt = 0;

        while(cnt < 4){

            if(check(mat, target)){
                return true;
            }

            rotate(mat, target, n);
            cnt++; 
        }

        return false;
    }

    private void rotate(int[][] mat, int[][] target, int n){
        // transpose

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // reverse
        
        for(int i=0; i<n; i++){
            int low = 0, high = n-1;
            
            while(low <= high){
                int temp = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = temp;

                low++; high--;
            }
        }

    }

    private boolean check(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
}

/* 


0 0 1
0 1 1
0 0 1


0 0 0
0 1 0
1 1 1

*/