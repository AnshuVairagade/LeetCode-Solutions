class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long range = 1;
        int max = 1;
        for(int t : time){
            max = Math.max(max, t);
        }

        long ans = 0;
        long low = 0L, high = (1L * max * totalTrips);
        while(low <= high){
            long mid = (low + high)/2;

            if(calcTrips(time, mid, totalTrips)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    // This code will give integer overflow check the failing test case
    private boolean calcTrips(int[] time, long curr, int totalTrips){
        long cnt = 0;
        for(int t : time){
            cnt += curr / t;
            if(cnt >= totalTrips) return true;
        }
        return false;
    }
}


/*

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int range = 1;
        for(int t : time){
            range = Math.max(range, t);
        }
        range = range * totalTrips;

        for(int t = 1; t <= range; t++){
            if(calcTrips(time, t, totalTrips)){
                return (1L*t);
            }
        }

        return 0L;
    }

    private boolean calcTrips(int time[], int curr, int totalTrips){
        int cnt = 0;
        for(int t : time){
            // System.out.println(curr);
            cnt += (curr/t);
            if(curr == 27){
                System.out.println(t + " "+(curr/t)+" " + cnt);
            }
        }

        return cnt >= totalTrips;
    }
}

*/