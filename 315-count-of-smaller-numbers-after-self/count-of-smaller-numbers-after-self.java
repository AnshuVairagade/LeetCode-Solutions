// why lb and not ub?? -> duplicates
// why do need reverse??  -> reverse looping
// Why to use add() and not set()???  -> duplicate elements

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        
        for(int i=n-1; i>=0; i--){
            int idx = upperBound(list, nums[i]);
            res.add(idx);
            list.add(idx, nums[i]);
        }

        Collections.reverse(res);

        return res;
    }

    private int upperBound(ArrayList<Integer> nums, int target){
        int n = nums.size();

        int low = 0, high = n-1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }
}