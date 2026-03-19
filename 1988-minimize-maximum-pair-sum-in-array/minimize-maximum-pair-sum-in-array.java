class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxPairSum = Integer.MIN_VALUE;

        int low = 0, high = nums.length - 1;
        while(low < high){
            maxPairSum = Math.max(maxPairSum, nums[low]+nums[high]);
            low++; high--;
        }

        return maxPairSum;
    }
}