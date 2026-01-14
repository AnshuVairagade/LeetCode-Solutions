// Code Documentation is given below

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int minElement = Integer.MAX_VALUE;

        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;

            // edge case handling
            if(nums[low] == nums[mid] && nums[mid] == nums[high] && low != high){
                high = high - 1;
                continue;
            }

            if(nums[low] <= nums[mid]){
                minElement = Math.min(minElement, nums[low]);
                low = mid + 1;
            }
            else{ // else if(nums[mid] <= nums[high])
                minElement = Math.min(minElement, nums[mid]); 
                high = mid - 1;
            }
        }

        return minElement == Integer.MAX_VALUE ? nums[0] : minElement;
    }
}



/*

// Find the edge cases


Approach:
For test case [3,1,2,3,3,3,3,3]
               |     |       |
              low   mid     high

That is the reason we have to trim down the search space using below code
if(nums[low] == nums[mid] && nums[mid] == nums[high]){
    high = high - 1;
    continue;
}

Now the new search space becomes valid one as showm in below example
For test case [1,1,2,3,4,5,6,1]
               |     |     |
              low   mid   high

Now on this search space binary search for minimum can be implemented correctly.




Solution : https://www.youtube.com/watch?v=K0PjrikGKK4


Worst case time complexity Discussion :

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/comments/1566279/



*/