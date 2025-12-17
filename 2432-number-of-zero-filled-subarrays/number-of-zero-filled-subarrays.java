class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long res = 0, cnt = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                cnt++;
                res += cnt;
            }
            else{
                cnt = 0;
            }
        }
        
        return res;
    }
}