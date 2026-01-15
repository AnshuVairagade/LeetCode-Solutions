class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int cnt = 0;
        long rightSum = 0;
        long leftSum = 0;
        for(int i=0; i<nums.length-1; i++){
            leftSum += nums[i];
            rightSum = totalSum - leftSum;

            if(leftSum >= rightSum) cnt++;
        }

        return cnt;
    }
}

/*
Brute force : Generate all the splits and count valid one
Use nested loops for calculating left sum and right sum
TC = O(n*n)
SC = O(1)


Better Solution : Prefix Sum
Calculate right sum from total sum using running left sum
TC = O(n)
SC = O(1)
*/