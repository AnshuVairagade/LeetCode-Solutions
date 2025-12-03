class Solution{
    public int findSmallestInteger(int[] nums, int k) {
        int n = nums.length;
        int freq[] = new int[k];

        for(int i=0; i<n; i++){
            int el = nums[i];
            int r = (el%k+k)%k;
            freq[r]++; 
        }

        // Same reainder can form multiple number by adding k
        int mex = 0;
        while(true){
            int r = mex % k;
            if(freq[r] == 0) break;
            freq[r]--;
            mex++;
        }

        return mex;
    }
}



/*

Your code checks actual positions to see if nums[i] = i
which only works for first missing positive type questions.

But here, positions do not matter.
What matters is how many times each remainder appears,
because each remainder allows you to form many numbers.

That is why the answer becomes 10, not 5.


class Solution {
    public int findSmallestInteger(int[] nums, int k) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int el = nums[i];
            nums[i] = (el%k+k)%k;
        }

        // cyclic sort
        for(int i=0; i<n; i++){
            int element = nums[i];
            int pos = element;

            if(pos<0 || pos >= n) continue;

            if(nums[pos] != nums[i]){
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                i--;
            }
        }

        for(int i=0; i<n; i++){
            if(i != nums[i]) return i;
        }

        return n;
    }
}



*/