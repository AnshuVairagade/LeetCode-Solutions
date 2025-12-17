class Solution {
    public int longestContinuousSubstring(String s) {
        int res = 1;
        int cnt = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)-s.charAt(i-1) == 1){
                cnt++;
                res = Math.max(res, cnt);
            }
            else cnt = 1;
        }

        return res;
    }
}

// abacabcdefga

