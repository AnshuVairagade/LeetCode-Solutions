class Solution {
    public long countSubstrings(String s, char c) {
        int n = s.length();

        long k = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == c) k = k + 1;
        }

        return (k * (k+1))/2;
    }
}

/*

Intuition: 

If 'c' appears k times, each valid substring is formed by choosing

a start and end occurrence of 'c' (start <= end).

1st occurrence can pair with k occurrences, 2nd with (k-1), ..., last with 1.

Total substrings = k + (k-1) + ... + 1 = k * (k + 1) / 2.

*/