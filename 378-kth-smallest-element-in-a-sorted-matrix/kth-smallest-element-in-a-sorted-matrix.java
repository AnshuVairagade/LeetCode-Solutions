class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0], high = matrix[m-1][n-1];
        while(low <= high){
            int mid = (low + high) / 2;

            int cnt = getCount(matrix, mid, m, n);
            if(cnt == k){
                high = mid - 1;
            }
            else if(cnt > k){
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return low;
    }

    private int getCount(int[][] matrix, int x, int m, int n){
        int cnt = 0;
        for(int i=0; i<m; i++){
            cnt += upperBound(matrix[i], x, m , n);
        }
        return cnt;
    }

    private int upperBound(int[] nums, int x, int m, int n){
        int low = 0, high = n-1;
        
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == x){
                low = mid + 1;
            }
            else if(nums[mid] > x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }   
        }

        return low;
    }
}



/*
Approaches :
------------

1) Brute Force : Array + Sorting + k-1 index
TC = O(m*n) + O(m*n*log(m*n))
SC = O(m*n)

2) Better : Matrix + Priority Queue
Intuition -> Merge K sorted arrays

TC = O(k)
SC = O(k)

3) Optimal : BS on Answer + Upper Bound
BS on Answer to find target and Upper Bound calculates element count
Intuition -> Row and Column Sorted


# Note :
1) why not property of row and column sorted BS template
1) Edge Cases


*/
