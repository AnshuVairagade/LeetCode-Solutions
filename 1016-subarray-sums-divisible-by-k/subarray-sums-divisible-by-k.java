class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0, sum = 0, key;

        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            key = (sum % k + k)%k;

            if(map.containsKey(key)){
                cnt += map.get(key);
            }

            map.put(key, map.getOrDefault(key, 0)+1);
        }

        return cnt;
    }
}


// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/comments/1772221/