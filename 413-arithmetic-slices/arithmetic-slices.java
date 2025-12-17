class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        int res = 0, cnt = 0;
        int prevDiff = nums[1]-nums[0];
        for(int i=2; i<n; i++){
            if(nums[i]-nums[i-1] == prevDiff){
                cnt++;
                res+= cnt;
            }
            else{
                cnt = 0;
                prevDiff = nums[i] - nums[i-1];
            }
        }
        
        return res;
    }


    /* Sliding window approach 


    public int numbeOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;

        int res = 0, cnt = 0;
        int pdiff = nums[1]-nums[0];

        // [1,2,3,4,3,2,1,7,7,7,7]

        int i = 0, j = 1;
        while(j<n){
            int cdiff = nums[j]-nums[j-1];

            if(cdiff == pdiff && j-i+1 >= 3){
                cnt++;
                res += cnt;
            }
            else if(cdiff != pdiff){
                if(j != n-1) pdiff = nums[j+1] - nums[j];
                cnt = 0;
                i = j-1;
            }
            j++;
        }

        return res;
    }

    */
}