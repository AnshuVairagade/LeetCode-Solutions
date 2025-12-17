class Solution {
    public int numSub(String s) {
        int n = s.length();
        int mod = 1000000007;
        long res = 0;

        int i=0, j=0;
        while(j<n){
            while(i<n && j<n && s.charAt(i) == '0' && s.charAt(j)=='0'){
                i++; j++;
            }

            while(j<n && s.charAt(j)=='1'){
                j++;
            }
            long len = (j-i)%mod;
            long cnt = (len * (len+1))/2;
            res = (res + cnt)%mod;
            i = j;
        }

        return (int)res;
    }
}


// Brute force : Generate all possible subarrays with looping

/*
Edge cases : 
"01100000011100"
"000000"


*/