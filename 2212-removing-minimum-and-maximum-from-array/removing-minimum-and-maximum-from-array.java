class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = minPosition(nums);
        int maxIdx = maxPosition(nums);

        int op1 = deleteFromBothSide(nums, minIdx, maxIdx);
        int op2 = deleteFromLeft(nums, minIdx, maxIdx);
        int op3 = deleteFromRight(nums, minIdx, maxIdx);

        int res = Math.min(op1, Math.min(op2, op3));
        return res;
    }

    private int deleteFromBothSide(int[] nums, int min, int max){
        int n = nums.length;
        int minDel = Math.min(n-min, min+1);
        int maxDel = Math.min(max+1, n-max);

        return minDel + maxDel;
    }

    private int deleteFromLeft(int nums[], int min, int max){
        int res = Math.max(min, max);
        return res + 1;
    }

    private int deleteFromRight(int[] nums, int min, int max){
        int res = Math.min(min, max);
        return nums.length-res;
    }

    private int minPosition(int nums[]){
        int min = Integer.MAX_VALUE;
        int idx = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    private int maxPosition(int nums[]){
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }

        return idx;
    }
}