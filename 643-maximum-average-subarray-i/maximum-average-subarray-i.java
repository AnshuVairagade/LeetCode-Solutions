class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0L;

        // Fix : Double.NEGATIVE_INFINITY for max comparisons
        double maxAverage = Double.NEGATIVE_INFINITY;

        int high = 0;
        while(high < k-1){
            sum += nums[high++];
        }
    
        int low = 0;
        while(high < nums.length){
            sum += nums[high++];
            double avg = (double)sum/k;
            maxAverage = Math.max(avg, maxAverage);
            sum -= nums[low++];
        }

        return maxAverage;
    }
}