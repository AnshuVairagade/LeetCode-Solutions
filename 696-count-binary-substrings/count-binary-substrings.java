class Solution {
    public int countBinarySubstrings(String s) {
        char nums[] = s.toCharArray();
        int n = s.length();
        if(n == 1) return 0;
        int cnt = 0;

        int flips = 0;
        int low = 0, high = 1;
        while(high < n){
            if(nums[high-1] != nums[high]){
                flips++;
            }

            if(flips > 1){
                int ones = 0;
                int zeros = 0;
                for(int i=low; i<high; i++) {
                    if(nums[i] == '1') ones++;
                    if(nums[i] == '0') zeros++;
                }
                int len = Math.min(ones, zeros);
                cnt += len;  
            }

            while(flips > 1){
                low = low + 1;
                if(nums[low-1] != nums[low]){
                    flips--;
                }
            }

            high++;
        }

        if(flips > 0){
            int ones = 0;
            int zeros = 0;
            for(int i=low; i<high; i++) {
                if(nums[i] == '1') ones++;
                if(nums[i] == '0') zeros++;
            }
            cnt += Math.min(ones, zeros);
        }

        return cnt;
    }
}