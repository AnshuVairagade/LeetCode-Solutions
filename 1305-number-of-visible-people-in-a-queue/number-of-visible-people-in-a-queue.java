class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        
        int res[] = new int[n];
        for(int i=n-1; i>=0; i--){
            int cnt = 0;

            while(!st.empty() && st.peek() < heights[i]){
                st.pop();
                res[i]++;
            }

            if(!st.empty()) res[i]++;
            st.push(heights[i]);
        }

        return res;
    }
}

/* Optimized approach

heights[] = [10,6,8,5,11,9]
nge[] =  [4,2,4,4,5,5]

https://leetcode.com/problems/number-of-visible-people-in-a-queue/solutions/1363940/cjavapython-monotonic-stack-visualize-pi-bo86

if nge do not exist then n-1 is nge;

Wrong Approach:
res[i] = nge[i] - i;

*/


/*
Brute force: min(heights[i], heights[j]) > prevMax

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        
        int res[] = new int[n];
        for(int i=0; i<n-1; i++){
            int prevMax = 0;
            int cnt = 0;
            for(int j=i+1; j<n; j++){
                if(Math.min(heights[i], heights[j]) > prevMax){
                    cnt++;
                }
                prevMax = Math.max(prevMax, heights[j]);
                if(prevMax > heights[i]) break;
            }
            res[i] = cnt;
        }
        res[n-1] = 0;

        return res;
    }
}

*/

