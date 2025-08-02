// https://leetcode.com/problems/count-the-number-of-good-subarrays/solutions/6655441/efficient-sliding-window-frequency-map-solution-beats-90

class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long cnt = 0;
        long pairs = 0;
        int l = 0, r = 0;
        while(r<n){
            pairs += map.getOrDefault(nums[r], 0);
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(pairs >= k){
                cnt += n-r;
                map.put(nums[l], map.get(nums[l])-1);
                pairs -= map.get(nums[l]);
                l++;
            }
            r++;
        }
        return cnt;
    }
}