// Greedy 

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] <= min1) min1 = nums[i];
            else if(nums[i] <= min2) min2 = nums[i];
            else return true;
        }

        return false;
    }

}

/*

// 79/85 test cases are passed
// Approach : for monotonic increasing stach return when st.size() > 2

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;

        Stack<Integer> st = new Stack<>();    
        for(int i=n-1; i>=0; i--){
            if(st.size() >= 3) return true;

            while(!st.empty() && st.peek() <= nums[i]) st.pop();
            st.push(nums[i]);
        }

        return st.size() >= 3;
    }
}
*/