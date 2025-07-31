// Sliding Window does not work due to upredictability of negative elements

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int cnt = 0, ps = 0, rps;

        map.put(0, 1); // There always lies a subarray of sum 0
        for(int i=0; i<n; i++){
            ps += nums[i];
            rps = ps - k;
            cnt += map.getOrDefault(rps, 0);
            map.put(ps, map.getOrDefault(ps, 0)+1); 
        }

        return cnt;
    }
}