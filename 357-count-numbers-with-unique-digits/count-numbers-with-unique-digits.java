// Maths solution

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        
        int ans = 10;
        int start = 9;
        int current = 9;
        while(n-->1 && start>0){
            current *= (start--);
            ans += current;
        }

        return ans;
    }
}

/* Backtracking Solution

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        return solve(n, "");
    }

    private int solve(int n, String num){
        if(num.length() == n) return 1;

        int ans = 0;
        for(int i=0; i<=9; i++){
            String dig = i+"";
            if(num.indexOf(dig) == -1){
                ans += solve(n, num+dig);
            }
        }

        return ans;
    }
}

*/