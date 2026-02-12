class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxDiv = 0;
        for(int num : nums){
            maxDiv = Math.max(num, maxDiv);
        }

        int low = 1, high = maxDiv;
        while(low <= high){
            int div = (low + high)/2;

            if(validDivisor(nums, div, threshold)){
                high = div - 1;
            }
            else low = div + 1;
        }      

        return low;
    }

    private boolean validDivisor(int nums[], int div, int threshold){
        int sumOfDiv = 0;
        for(int num : nums){
            sumOfDiv += Math.ceil((double)num/div);
        }
        // System.out.println(sumOfDiv);
        return sumOfDiv <= threshold;
    }


    public int linearTraveral(int[] nums, int threshold) {
        int maxDiv = 0;
        for(int num : nums){
            maxDiv = Math.max(num, maxDiv);
        }

        for(int div = 1; div <= maxDiv; div++){
            if(validDivisor(nums, div, threshold)){
                return div;
            }
        }
        
        return -1;    
    }
}