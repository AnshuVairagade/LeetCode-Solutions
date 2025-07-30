// In the NSE and PSE implementation always think of duplicate element edge 

// Aam Zindagi : O(N*N) => 2 for loops
// Mentos Zindagi : O(N) => Monotonic Stack 
// Sum of Subarray Maximum - Sum of Subarray Minimum : SC : 

class Solution {
    public long optimized(int[] A) {
        int n = A.length, j, k;
        long res = 0;
        
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        
        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }

    public long subArrayRanges(int[] nums) {
        // Brute force solution
        int n = nums.length;
        long total = 0;
        int min , max;

        for(int i=0; i<n; i++){
            min = nums[i];
            max = nums[i];

            for(int j=i; j<n; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                total += (max - min);
            }
        }
        return total;
    }
}