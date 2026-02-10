// Documentation below

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b)->a[0]-b[0]);

        Long dp[] = new Long[rides.length+1];

        return helper(0, rides, dp);
    }

    private long helper(int i, int[][] rides, Long[] dp){
        if(i == rides.length){
            return 0L;
        }

        if(dp[i] != null) return dp[i];

        long nopick = helper(i+1, rides, dp);

        int start = rides[i][0];
        int end = rides[i][1];
        int tip = rides[i][2];

        int next = nextRide(rides, i, end);
        long pick = (end - start + tip) + helper(next, rides, dp);

        return dp[i] = Math.max(pick, nopick);
    }

    private int nextRide(int[][] rides, int idx, int prev){
        int low = idx + 1, high = rides.length-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(rides[mid][0] < prev){
                low = mid+1;
            }
            else high = mid-1;
        }

        return low;
    }
}

/* 
Analyze the time complexity??? (Do not forget sorting)

For the optimization use Binary Search to efficiently find the next ride

*/