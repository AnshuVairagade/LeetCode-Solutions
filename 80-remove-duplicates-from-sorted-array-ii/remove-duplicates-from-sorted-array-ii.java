class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int j = 2;


        int k = 2;
        for(int i=2; i<n; i++){
            if(nums[i] == nums[j-1] && nums[i] == nums[j-2]){
                continue;
            }

            nums[j++] = nums[i];
            k++;
        }

        System.out.println(k);

        return k;
    }
}

/*
Brute Force: 

Input: [0,0,1,1,1,1,2,3,3]

0 -> 2
1 -> 4
2 -> 1
3 -> 2

[0, 0, 1, 1, 2, 3, 3, _, _]


TC = O(n)  
SC = O(n)  -> Hashamp




Optimal Approach:

Use counter to store frequency


Input: [0,0,0,1,1,1,1,2,3,3]

cnt = 1

i = 4
j = 3

[0, 0, 1, ]






*/