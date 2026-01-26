class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int res[] = new int[n];

        long prevRem = 0;
        for(int i=0; i<n; i++){
            long dig = word.charAt(i) - '0';
            long num = prevRem * 10 + dig;

            long rem = num % m;
            if(rem == 0) res[i] = 1;
            else res[i] = 0;

            prevRem = rem;
        }
        return res;
    }
}

/*
Solution : https://leetcode.com/problems/find-the-divisibility-array-of-a-string/solutions/3230950/stepwise-explanation-with-images-easy-to-uzea

My Intuition:
--------------

Only possible way for optimization is to break the number into pieces so that I can check divisibility

Breaked number into the pieces but does not work because it does not guarantee the valid answer 
0

Brute force: 
------------

Build the number and check the divisibility
But as word.length can be 10^5 hence cannot build the number due to overflow


*/