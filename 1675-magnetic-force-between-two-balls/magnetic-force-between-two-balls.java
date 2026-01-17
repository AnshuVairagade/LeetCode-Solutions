// Code Documentation given below

class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);
        int lim = position[n-1] - position[0];

        int maxMinForce = -1;
        int low = 1, high = lim;
        while(low <= high){
            int mid = low + (high - low) /2;

            if(canPlace(position, m, mid)){
                maxMinForce = Math.max(maxMinForce, mid);
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return maxMinForce;
    }

    private boolean canPlace(int[] position, int m, int force){
        int cnt = 1;
        int prev = position[0];

        for(int i=1; i<position.length; i++){
            int currForce = Math.abs(position[i]-prev);
            if(currForce >= force){
                cnt++;
                prev = position[i];
            }

            if(cnt == m) return true;
        }

        return cnt == m;
    }
}


/*

Brute Force: 
-------------
Approach:
Answer will lie in between 1 to max-min
Check all the possible distance(force) for which ball be placed

TC = O(n + (max-min))         ->  since max ~ 10^9 got TLE



Optimal Solution: Binary Search
-------------------------------
Intution : Linear search space
Approach : BS on Answer (aggresive cows)

TC = O(n * log(max-min))



# Burte Force Code:
-------------------

class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);
        int lim = position[n-1] - position[0];

        int maxMinForce = -1;
        for(int force=1; force <= lim; force++){
            if(canPlace(position, m, force)){
                maxMinForce = force;
            }
        }

        return maxMinForce;
    }

    private boolean canPlace(int[] position, int m, int force){
        int cnt = 1;
        int prev = position[0];

        for(int i=1; i<position.length; i++){
            int currForce = Math.abs(position[i]-prev);
            if(currForce >= force){
                cnt++;
                prev = position[i];
            }

            if(cnt == m) return true;
        }

        return cnt == m;
    }
}


*/