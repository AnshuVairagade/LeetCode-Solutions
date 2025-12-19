class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int total = 0;
        int maxTotal = 0;
        
        for(int i=n-1; i>=0 && satisfaction[i] > -total; i--){
            total += satisfaction[i];
            maxTotal += total;
        }

        return maxTotal;
    }
}


/* Optimal : Greedy
Prepare dishes with maximum satisfaction value first 
TC = O(nlog(n))

*/

/*
Brute Force :

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int maxCoef = Integer.MIN_VALUE;

        Arrays.sort(satisfaction);
        
        for(int i=0; i<n; i++){
            int curr = 0, time = 1;
            for(int j=i; j<n; j++){
                curr += (time * satisfaction[j]);
                time++;
            }
            maxCoef = Math.max(curr, maxCoef);
        }

        return maxCoef<0 ? 0 : maxCoef;
    }
}

*/ 


// [-9,-8,-1,0,5]