// Code documentation is given below

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int res = -1;

        int low = 1, high = Integer.MIN_VALUE;
        for(int quantity : quantities) high = Math.max(high, quantity); 

        while(low <= high){
            int mid = (low + high)/2;

            int cnt = distribute(quantities, mid);
            if(cnt <= n){
                res = mid;
                high = mid - 1;
            }
            // else if(cnt < n){
            //     high = mid - 1;
            // }
            else if(cnt > n){
                low = mid + 1;
            }
        }

        return res;
    }

    private int distribute(int[] quantities, int lim){
        int cnt = 0;
        for(int quantity : quantities){
            cnt += Math.ceil((double)quantity/lim);
        }
        return cnt;
    }
}


/* 

BS Framerwork:
1) Find limits
2) Window shrinking
3) Answer calculation


Similar questions on LEETCODE are :

Ques. No. 1552
Ques. No. 1870
Ques. No. 875
Ques. No. 1283
Ques. No. 1482
Ques. No. 2064


Optimal Solution: Binary Search
------------------

Intutition : Minimum of Maximum 

Approach:
---------
Consider quantities = [11,6], n = 6 (ceiling division)
k = 1 11/1 + 6/1 = 17
k = 2 11/2 + 6/2 = 6 + 3 = 9  Distribute: 1 2 2 2 2 2 2 2 2
k = 3 11/3 + 6/3 = 4 + 2 = 6  Distribute: 2 3 3 3 3 3 <-- Condition met from here
k = 4 11/4 + 6/4 = 3 + 2 = 5  Distribute: 3 4 4 2 4 0
k = 5 11/5 + 6/5 = 3 + 2 = 5  Distribute: 1 5 5 1 5 0
k = 6 11/6 + 6/6 = 2 + 1 = 3  Distribute: 5 6 6 0 0 0
...
k = 11 11/11 + 6/11 = 1   Distribute: 11 0 0 0 0 0

In other words,  [  17, 9, 6, 5, 5, 3]
or       [  F, F, T, T, T, T]
ie      k = [ 0, 1, 2, 3, 4, 5, 6]
ie           ^
we can start with l=1
*/