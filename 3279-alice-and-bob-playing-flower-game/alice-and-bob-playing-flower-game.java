class Solution {
    public long flowerGame(int n, int m) {
        long x = 1L * ((n+1)/2) * (m/2) ;
        long y = 1L * (n/2)* ((m+1)/2);
        return x + y;
    }
}


/* When total flower count becomes odd alice always win as alice starts first

x = odd * even  = ceil(n) * floor(m) = ((n+1)/2 * m/2) ;
y = even * odd = floor(n) * ceil(m) = ((n/2)* (m+1)/2) ;


return x + y ( total possible odd numbers formed by all the possible combinations)
*/