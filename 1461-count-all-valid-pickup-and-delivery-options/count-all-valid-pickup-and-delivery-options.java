class Solution {
    int mod = 1000000007;

    public int countOrders(int n) {
        return calculate(n);
    }

    private int calculate(int n){
        if(n == 1) return 1;

        long next = calculate(n-1);

        long spaces = (long)(n-1)*2 + 1;
        long arrangements = ((spaces * (spaces+1))/2)%mod;
        long res = (next * arrangements)%mod;

        return (int)res;
    }
}

/* Handle Integer overflow of multiplication using long variables 

Multiplication can cause overflow thats why use long variables to multiply 
Then take the modulo of each step to make answer valid
return integer casted answer

*/

/* 
Brute force :
--------------
Generate all the possible combination of pickup and delivery
Select the valid ones


Better Solution :
-------------------

n = 1 =>   p1d1
           _____

n = 2 => __ p1 __ d1 __

possilbe combinations :
p2d2 p1 __ d1 __   }
p2 p1 d2 d1 __     } p2 at first gap
p2 p1 __ d1 d2     }
__ p1 p2d2 d1 __   ] p2 at second gap
__ p1 p2 d1 d2     ]
__ p1 __ d1 p2d2   ) p2 at third gap

In the above example, spaces = 3 and arragements = 5
spaces = (n-1)*2 + 1;
arrangements = (spaces * (spaces + 1)) / 2

n = 3 => arrange p3 & d3 in 6 combinations of n = 2;

*/