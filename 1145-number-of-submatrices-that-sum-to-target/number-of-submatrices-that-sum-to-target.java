class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Storing the row sum
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }   

        // Downword Traversal of the matrix to find all the subarray having the sum equal to target
        int cnt = 0;
        for(int sc = 0; sc < n; sc++){

            // Fix the starting point and then move downwards
            for(int j=sc; j<n; j++){
                
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for(int i=0; i<m; i++){
                    sum += matrix[i][j] - ((sc > 0) ? matrix[i][sc-1] : 0);
                    int rsd = sum - k;

                    if(map.containsKey(rsd)){
                        cnt += map.get(rsd);
                    }

                    map.put(sum, map.getOrDefault(sum, 0)+1);
                }
            }
        }

        return cnt;
    }
}

// TC : O(N^3)
// SC : O(1) / O(N*N)