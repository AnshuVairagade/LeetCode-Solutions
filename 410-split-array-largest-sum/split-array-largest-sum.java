// Code Documentation are given below

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        
        int maxElement = nums[0] ;
        int maxSum = 0;
        for(int num : nums){
            maxElement = Math.max(maxElement, num);
            maxSum += num;
        }
        
        int low = maxElement, high = maxSum;
        while(low <= high){
            int mid = (low + high) / 2;

            int parts = countParts(nums, mid, k);
            if(parts <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    private int countParts(int[] nums, int lim, int k){
        int cnt = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > lim){
                cnt++;
                sum = nums[i];
            }
        }
        cnt++; // edge case : counting last part

        return cnt;
    }
    
}

/*


Edge case for above problem: 
-> When nums[i] = 10^6 for  nums.length = 1000


Intuition : 
1) Max of Min KeywWord (Allocate book || Painters Partition)
2) Example Visualisation by breaking array into parts


Approach : 
Check how many parts array can be broken into using the given sum 
Take action when parts < = > k


Steps:
1) Find the low and high (k=1 && k=n)
2) compare k value with parts for current mid
3) Logic to eleminate halves for < = > conditions
4) Return low (minimum of maximum sum for which array can be divided into k parts) 


TC = 




*/