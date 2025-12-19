class Solution {
    public int kthFactor(int n, int k) {
        
        // Forward pass
        int f;
        for(f=1; f*f <= n; f++){
            if(n%f == 0) k--;
            if(k == 0) return f;
        }

        // Backward pass
        for(f=f-1; f>0; f--){
            if(f*f == n) continue;
            if(n%f == 0) k--;
            if(k == 0) return n/f;
        }

        return -1;
    }
}

/* 
Optimal Solution : 
Factor after sqrt(n) are mirror image of factor after n/2, consider below example
               12         sqrt(12) = 3.___
          / / / | \ \ \        
          1 2 3 | 4 6 12

https://www.youtube.com/watch?v=xfY7qQ270sY

*/ 


/* Brute force : 
Check for all the factors from 1 till n
TC = O(N)

class Solution {
    public int kthFactor(int n, int k) {
        int cnt = 1;

        for(int i=2; i<=n; i++){
            if(n%i == 0) cnt++;
            if(cnt == k) return i;
        }

        return -1;
    }
}

*/