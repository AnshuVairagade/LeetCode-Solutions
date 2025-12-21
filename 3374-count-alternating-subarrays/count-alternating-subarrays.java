class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long cnt = 1;
        long res = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                cnt++;
                res += cnt;
            }
            else{
                cnt = 1;
                res += 1;
            }
        }

        return res;
    }
}