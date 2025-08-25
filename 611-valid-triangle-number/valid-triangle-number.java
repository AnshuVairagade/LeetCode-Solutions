class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for(int i=nums.length-1; i>=0; i--){
            int low = 0, high = i-1;
            while(low < high){
                if(nums[low]+nums[high] > nums[i]){
                    ans += (high - low);
                    high--;
                }
                else low++;
            }
        }

        return ans;
    }
}