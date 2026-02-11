// Understand the intuition and Dry Run the example

class Solution {
    int mod = (int)(1e9+7);

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int engr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            engr[i][0] = speed[i];
            engr[i][1] = efficiency[i];
        }

        long sum = 0;
        Arrays.sort(engr, (a, b) -> b[1] - a[1]);

        /* Bug point : here you have to choose at most k
        for(int i=0; i<k-1; i++){
            sum += engr[i][0];
            pq.offer(speed[i][0]);
        } 
        */

        long maxPerformance = 0;
        for(int i=0; i<n; i++){
            sum += engr[i][0];
            pq.offer(engr[i][0]);

            if(pq.size() > k){
                sum -= pq.poll();
            }
        
            long performance = sum * engr[i][1];
            maxPerformance = Math.max(maxPerformance, performance);
        }

        return (int)(maxPerformance % mod);
    }
}