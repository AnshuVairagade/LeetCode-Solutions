/* Missing Children Algorithm
-> Mom finds missing children by awarding chocolate at thier correct position
*/

class Solution{
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int element = nums[i];
            int chair = element-1;

            if(chair <0 || chair >= n) continue;

            // Swap children to its correct place
            if(nums[i] != nums[chair]){
                int temp = nums[i];
                nums[i] = nums[chair];
                nums[chair] = temp;
                i--;
            }
        }

        for(int i=0; i<n; i++){
            if(i+1 != nums[i]) return i+1;
        }

        return n+1;
    }
}


// Only if there is one element missing

/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n =  nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // finding minimum and maximum
        for(int num : nums){
            if(num<1) continue;
            if(num < min) min = num;
            sum += num;
            max = Math.max(max, num);
        }

        if(min != 1) return 1;
        int total = (int)(1L*(max+1)*max)/2;

        return total == sum ? max+1 : total - sum;
    }
}
*/