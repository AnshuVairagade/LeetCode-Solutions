class Solution {
    public double myPow(double x, int n) {
        return solve(x, n);
    }

    private double solve(double x, long n){
        if(n == 0) return 1;
        if(n < 0) return solve(1/x, -1*n);
        if(n%2 == 0) return solve(x*x, n/2);

        return x*solve(x*x, (n-1)/2);
    }
}

/*
Using the binary exponentiation to reduce total number of computations
TC => O(log(n))
SC => O(1)

Approach : 
-----------
x^8 = (x*x)^4             <--- odd case
x^9 = x*(x*x)^4           <--- even case

x^-9 = (1/x)^9            <--- negative power 

Base case : x^0 = 1

Reduce the number till it becomes zero and return the multiplication

 */