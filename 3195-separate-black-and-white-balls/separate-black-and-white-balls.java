class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long cnt = 0;

        char chars[] = s.toCharArray();

        int j = n-1;
        for(int i=n-1; i>=0; i--){
            if(chars[i] == '1' && chars[j] == '0'){
                cnt += (j - i);

                // swapping
                chars[j] = '1';
                chars[i] = '0';
            }

            if(chars[j] == '1') j--;
        }

        return cnt;
    }

}


/* 

Brute Force: 
    Bubble sort
    TC -> O(n * n) -> fail X

Edge Cases :

1) All whites: 
Input: "000000"


2) All balcks:
Input: "11111"


3) Large Input:
Input: "1000001000101011011011001010"




11001010            swap = 1
      ij

11001001            swap = 3
    i j

11000011            swap = 7
 i   j

10000111            swap = 11
i   j


Approach:

Keep two pointers i and j

move i from back to front

swap if mismatch and count the swap

i--;
if(j == 1) j--;


mismatch = str.charAt(i) == '1' && str.charAt(j) == '0':

what if i andd j start from same point

*/


