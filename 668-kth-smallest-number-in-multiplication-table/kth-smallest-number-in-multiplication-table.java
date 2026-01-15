// Code documentation given below

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m*n;
    
        while(low <= high){
            int mid = (low + high)/2;

            int cnt = getCount(m, n, mid);
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

    private int getCount(int m, int n, int k){
        int cnt = 0;
        for(int i=0; i<m; i++){
            cnt += upperBound(m, n, i, k);
        }
        return cnt;
    }

    private int upperBound(int m, int n, int r, int k){
        int low = 0, high = n-1;
        
        while(low <= high){
            int mid = (low + high)/2;

            int elem = (r+1)*(mid+1);  // bug point
            if(elem == k){
                low = mid + 1;
            }
            else if(elem > k){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        
        return low;
    }
}


/* 


Similar to problem : 378. Kth Smallest Element in a Sorted Matrix

Here matrix is not given
To form matrix cost O(m*n) time complexity, to overcome this cost we use property
mat[i][j] == i * j


Understand :
1) Binary Search on Answer
2) Upper Bound without given matrix 


# For detailed explanation visit problem 378 docs.


*/