// TC = O(m × n × min(m,n))

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int maxSide = 0;
        int low = 1, high = Math.min(m, n);
        while(low <= high){
            int side = (low + high)/2;

            if(checkSquare(side, mat, threshold)){
                maxSide = side;
                low = side + 1;
            }
            else high = side - 1;
        }

        return maxSide;
    }

    private boolean checkSquare(int side, int mat[][], int k){
        int m = mat.length;
        int n = mat[0].length;
        int prefix[][] = buildPrefixSum(mat);

        for(int r = 0; r <= m-side; r++){
            for(int c = 0; c <= n-side; c++){
                int r2 = r + side - 1;
                int c2 = c + side - 1;

                int up = r > 0 ? prefix[r-1][c2] : 0;
                int left = c > 0 ? prefix[r2][c-1] : 0;
                int diag = (r>0 && c>0) ? prefix[r-1][c-1] : 0;

                int sum = prefix[r2][c2] - up - left + diag;

                if(sum <= k) return true;
            }
        }


        return false;
    }

    private int[][] buildPrefixSum(int mat[][]){
        int m = mat.length;
        int n = mat[0].length;
    
        int[][] psmat = new int[m][n];

        psmat[0][0] = mat[0][0];
        for(int i=1; i<m; i++) psmat[i][0] = psmat[i-1][0] + mat[i][0]; 
        for(int j=1; j<n; j++) psmat[0][j] = psmat[0][j-1] + mat[0][j];

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                int sumUp = i>0 ? psmat[i-1][j] : 0;
                int sumDown = j>0 ? psmat[i][j-1] : 0;
                int sumDaigonal = i>0 && j>0 ? psmat[i-1][j-1] : 0; 
                psmat[i][j] = mat[i][j] + sumUp +  sumDown - sumDaigonal; 
            }
        }

        return psmat;
    }
}

