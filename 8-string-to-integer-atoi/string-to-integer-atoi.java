class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        String num = s.trim();
        if (num.isEmpty()) return 0;

        int st = 0;
        boolean neg = false;
        if(num.charAt(st) == '-'){
            neg = true; st++;
        }
        else if(num.charAt(st) =='+') st++;

        while(st<num.length() && num.charAt(st) == '0') st++;

        int ans = 0;
        for(int i=st; i<num.length(); i++){
            char ch = num.charAt(i);
            if(ch<'0' || ch >'9') break;
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && ch-'0'>Integer.MAX_VALUE%10)){
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans*10 + (ch-'0');
        }

        return neg ? -1 * ans : ans;
    }
}