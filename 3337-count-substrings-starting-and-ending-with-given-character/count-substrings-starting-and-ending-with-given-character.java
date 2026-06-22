class Solution {
    public long countSubstrings(String s, char c) {
        int n = s.length();

        int cnt = 0;
        long total = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == c){
                total += (cnt + 1);
                cnt = cnt + 1;
            }
        }

        return total;
    }
}

/*
Approach: Calculate how many can end at current position, you will find already caluculated about the strating ones.

Because ending one already contains starting ones.

Intuition: Monotonicity of increasing substring with previously counted as they can be starting and 


i = 2
total = 1 + 2 + 3
cnt = 3




*/