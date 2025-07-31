// Hint : Largest subarray with target sum equal to zero (replace zero with -1)

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int ps=0, ans = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] == 1) ps++;
            else ps--;

            if(map.containsKey(ps)){
                ans = Math.max(ans, i-map.get(ps));
            }
            else map.put(ps, i);
        }

        return ans;
    }
}