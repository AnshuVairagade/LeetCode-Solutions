class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int cnt = 1;
        nums[0] = nums[0] - k;
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            int min = nums[i] - k;
            int max = nums[i] + k;
            if(prev < min){
                prev = min;
                cnt++;
                nums[i] = min;
            }
            else if( prev < max){
                prev = prev+1;
                cnt++;
                nums[i] = prev+1;
            }
        }

        return cnt;
    }
}