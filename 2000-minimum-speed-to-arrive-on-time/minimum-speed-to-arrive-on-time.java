// What will be upper boundary??? 
// Observe : Tests are generated such that the answer will not exceed 10^7

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        
        int maxSpeed = dist[0];
        for(int i=0; i<n; i++){
            maxSpeed = Math.max(maxSpeed, dist[i]);
        }

        int minSpeed = -1;

        int lowSpeed = 1, highSpeed = 10000000;
        while(lowSpeed <= highSpeed){
            int speed = (lowSpeed + highSpeed) / 2;

            if(reachDestination(speed, dist, hour)){
                minSpeed = speed;
                highSpeed = speed - 1;
            }
            else lowSpeed = speed + 1;
        }

        return minSpeed;
    }

    private boolean reachDestination(int speed, int[] dist, double hour){
        int n = dist.length-1;
        double time = 0.0;

        for(int i=0; i<n; i++){
            time += Math.ceil((double)dist[i]/speed);
        }

        time += ((double)dist[n]/speed);

        return time <= hour;
    }
}


/* Iterative Solution

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        
        int maxSpeed = dist[0];
        for(int i=0; i<n; i++){
            maxSpeed = Math.max(maxSpeed, dist[i]);
        }

        int minSpeed = -1;

        int lowSpeed = 1, highSpeed = maxSpeed;
        while(lowSpeed <= highSpeed){
            int speed = (lowSpeed + highSpeed) / 2;

            if(reachDestination(speed, dist, hour)){
                minSpeed = speed;
                highSpeed = speed - 1;
            }
            else lowSpeed = speed + 1;
        }

       
        // for(int speed=1; speed<=maxSpeed; speed++){
        //     if(reachDestination(speed, dist, hour)){
        //         return speed;
        //     }
        // }
    

        return minSpeed;
    }

    private boolean reachDestination(int speed, int[] dist, double hour){
        int n = dist.length-1;
        double time = 0.0;

        for(int i=0; i<n; i++){
            time += Math.ceil((double)dist[i]/speed);
        }

        time += ((double)dist[n]/speed);

        return time <= hour;
    }
}

*/