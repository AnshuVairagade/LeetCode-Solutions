class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ops = new int[n];

        int leftOps[] = new int[n];
        int leftCnt[] = new int[n];
        leftOps[0] = 0;
        leftCnt[0] = boxes.charAt(0) == '1' ? 1 : 0;
        for(int i=1; i<n; i++){
            leftOps[i] = leftOps[i-1]+leftCnt[i-1];
            leftCnt[i] = leftCnt[i-1];
            if(boxes.charAt(i) == '1') leftCnt[i]++ ;
        }

        int rightOps[] = new int[n];
        int rightCnt[] = new int[n];
        rightOps[n-1] = 0;
        rightCnt[n-1] = boxes.charAt(n-1) == '1' ? 1 : 0;
        for(int i=n-2; i>=0; i--){
            rightOps[i] = rightOps[i+1]+rightCnt[i+1];
            rightCnt[i] = rightCnt[i+1];
            if(boxes.charAt(i) == '1') rightCnt[i]++;
        }

        for(int i=0; i<n; i++){
            ops[i] = leftOps[i] + rightOps[i]; 
        }

        return ops;
    }
}



/*
Optimal Solution:
--------------------

Intuition: 
Pattern of using previous and next knowledge boild down to prefix and suffix sum 

Approach:
At any idex i we have to shift total count of one till (i-1)th index that requires operations to move all that one till (i-1)th index


// leftOps[i] = leftOps[i-1]+leftCnt[i-1];
// rightOps[i] = rightOps[i+1]+rightCnt[i+1];


Dry Run:

boxes = "110"

leftOps = [0,1,3]
leftCnt = [1,2,2]

rightOps = [1,0,0]
rightCnt = [2,1,0]

output = [1,1,3]

TC = O(n) + O(n) + O(n)  => O(n)
SC = O(n) + O(n) + O(n)  => O(n)

*/ 



/* Brute Force :

TestCase : // 1101011

class Solution {
    public int[] minOperations(String boxes) {
        int[] ops = new int[boxes.length()];

        for(int i=0; i<boxes.length(); i++){

            int curr = 0;
            for(int j=0; j<boxes.length(); j++){
                if(boxes.charAt(j) == '1'){
                    curr += Math.abs(j-i);
                }
            }

            ops[i] = curr;
        }

        return ops;
    }
}

*/

