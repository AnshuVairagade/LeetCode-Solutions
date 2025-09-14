class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        String bin = Integer.toBinaryString(n);
        if(bin.length()%2==0)  return false;
        int cnt = 0;
        for(int i=0; i<bin.length(); i++){
            char ch = bin.charAt(i);
            if(ch == '1' && i!=0)  return false;
        }
        return true;
    }
}