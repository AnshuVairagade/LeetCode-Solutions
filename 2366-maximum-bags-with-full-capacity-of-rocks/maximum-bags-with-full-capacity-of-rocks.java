class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int req[] = new int[n];

        for(int i=0; i<n; i++){
            req[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(req);
        int cnt = 0;
        for(int i=0;  i<n; i++){
            if(req[i] > additionalRocks) break;
            additionalRocks -= req[i];
            cnt++;
        }

        // while(additionalRocks > 0 && i < n){
        //     if(req[i] <= additionalRocks){
        //         additionalRocks -= req[i];
        //         cnt++;
        //     }
        //     i++;
        // }

        // while(i < n && req[i] <= additionalRocks){
        //     additionalRocks -= req[i];
        //     cnt++;
        //     i++;
        // }

        return cnt;
    }
}

/*

Intuition:
If you cannot fulfill current requirement then no chance for bigger ones.
 
*/ 


