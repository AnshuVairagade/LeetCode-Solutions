// Find the monotonous last monotonous increasing end from end
// Process: 332 → 329 → 299

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int len = num.length;

        int mIncrEnd = len-1;
        for(int i=len-1; i>0; i--){
            if(num[i-1] > num[i]){
                mIncrEnd = i-1;
                num[mIncrEnd]--;
            }
        }

        for(int i=mIncrEnd+1; i<len; i++){
            num[i] = '9';
        }

        return Integer.parseInt(new String(num));
    }
}


// Brute force 
/*

class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        for(int i=n; i>=0; i--){
            if(monotonic(i)) return i;
        }
        return 0;
    }

    private boolean monotonic(int n){
        String s = n+"";
        for(int i=s.length()-2; i>=0 ; i--){
            if(s.charAt(i) > s.charAt(i+1)) return false;
        }
        return true;
    }
}

*/