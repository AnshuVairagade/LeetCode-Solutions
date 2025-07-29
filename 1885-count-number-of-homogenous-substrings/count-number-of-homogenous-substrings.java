class Solution {
    public int countHomogenous(String s) {
        int m = 1000000007, len;
        int n = s.length();
        int i=0, j=0;
        long cnt = 0;

        while(j<n){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            else{
                len = j-i;
                cnt = (cnt + ((long)len*(len+1)/2)%m)%m;
                i = j;
            }
        }
        len = j-i;
        cnt = (cnt + ((long)len*(len+1)/2)%m)%m;
        return (int)cnt;
    }
}