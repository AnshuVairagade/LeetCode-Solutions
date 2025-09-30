/* Optimized code :
To find the kth column of the nth row of the Pascal's Triangle:

// Combination formula: 
//     n!          factorial(n)
// ----------- = ------------------
// r!(n - r)!    factorial(r) * factorial(n - r)
​
*/

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        for (int size = n; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}


/*
class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        for(int num : nums) curr.add(num);

        while(curr.size() > 1){
            List<Integer> next = new ArrayList<>();
            for(int i=0; i<curr.size()-1; i++){
                int sum = curr.get(i)+curr.get(i+1);
                next.add(sum%10);
            }
            curr = next;
        }

        return curr.get(0);
    }
}
*/