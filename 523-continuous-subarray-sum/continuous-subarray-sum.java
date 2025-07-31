// Due to unambigous increase sum and multiple possible divisors it is invalid to implement sliding window.

// Hint : Leetcode 525 ( Prefix sum with Hashing )

// Imaging build a prefix sum array and % every element by k, when there is same value at two different index, the sum in between them is multiple of k.

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ps = 0, key;

        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            ps += nums[i];
            key = ps%k;

            if(map.containsKey(key) &&  (i - map.get(key) >= 2)){
                return true;
            }
            else if(!map.containsKey(key)) map.put(key, i);
        }

        return false;
    }
}