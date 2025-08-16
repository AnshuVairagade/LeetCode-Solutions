// Approach 1 : Generate all the subarrrays and find the maxScore => TC : O(N*N)

class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0]*nums[0];
        
        long preGcd[] = new long[n];
        long sufGcd[] = new long[n];
        long preLcm[] = new long[n];
        long sufLcm[] = new long[n];

        preGcd[0] = nums[0];
        preLcm[0] = nums[0];
        sufGcd[n-1] = nums[n-1];
        sufLcm[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--){
            sufGcd[i] = gcd(sufGcd[i+1], nums[i]);
            sufLcm[i] = lcm(sufLcm[i+1], nums[i]);
        }

        for(int i=1; i<n; i++){
            preGcd[i] = gcd(preGcd[i-1], nums[i]);
            preLcm[i] = lcm(preLcm[i-1], nums[i]);
        }

        long maxScore = preGcd[n-1]*preLcm[n-1];
        long currScore = 0;
        long nLcm, nGcd;
        for(int skip=0; skip<n; skip++){
            if(skip == 0){
                nGcd = sufGcd[1];
                nLcm = sufLcm[1]; 
            }
            else if(skip == n-1){
                nGcd = preGcd[n-2];
                nLcm = preLcm[n-2];
            }
            else{
                nGcd = gcd(preGcd[skip-1], sufGcd[skip+1]);
                nLcm = lcm(preLcm[skip-1], sufLcm[skip+1]);
            }
            currScore = nLcm * nGcd;
            maxScore = Math.max(maxScore, currScore);
        }

        return maxScore;
    }

    private long gcd(long a, long b){
        return (b==0) ? a : gcd(b, a%b);
    }

    private long lcm(long a, long b){
        return a*b / gcd(a,b);
    }
}