class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        Stack<Integer> st = new Stack<>();
        
        int second = Integer.MIN_VALUE;
        for(int k=n-1; k>=0; k--){
            if(nums[k] < second) return true;

            while(!st.empty() && st.peek() < nums[k]){
                second = st.peek();
                st.pop();
            } 

            st.push(nums[k]);
        }

        return false;
    }
}


/* Passes 89/107 test cases

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        
        for(int k=0; k<nums.length; k++){

            while(!st.empty() && st.peek() >= nums[k]){
                if(st.size()>=2 && nums[k] < st.peek()){
                    int j = st.peek(); st.pop();
                    int i = st.peek(); st.pop();
                    if(i < nums[k] && nums[k] < j) return true;
                    st.push(i);
                    st.push(j);
                }
                st.pop();
            } 
            st.push(nums[k]);
        }

        return false;
    }
}

*/