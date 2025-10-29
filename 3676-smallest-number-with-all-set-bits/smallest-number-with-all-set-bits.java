class Solution {
    public int smallestNumber(int n) {
        for(int i=n; i<=Integer.MAX_VALUE; i++){
            if(check(i)) return i;
        }
        return -1;
    }

    private boolean check(int n){
        String str = Integer.toBinaryString(n);
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != '1') return false;
        }

        return true;
    }
}