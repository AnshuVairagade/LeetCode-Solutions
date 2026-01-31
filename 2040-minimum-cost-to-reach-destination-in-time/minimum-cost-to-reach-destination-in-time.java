class Solution {
    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n = fees.length;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int minTime[] = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        pq.add(new int[]{0, fees[0], 0});
        // minTime[0] = 0;    bug point

        while(!pq.isEmpty()){
            int[] city = pq.poll();

            int cityNo = city[0];
            int cost = city[1];
            int time = city[2];

            if(time >= minTime[cityNo] || time > maxTime){
                continue;  // bug impacted over here
            }

            if(cityNo == n-1){
                return cost;
            }

            minTime[cityNo] = time;

            for(int adjCity[] : graph.get(cityNo)){
                int adjCityNo = adjCity[0];
                int timeToTravel = time + adjCity[1];
                int totalCost = cost + fees[adjCityNo];

                pq.offer(new int[]{adjCityNo, totalCost, timeToTravel});
            }
        }

        return -1;
    }
}


// Clean source code give below

// Wrong approach is also given below




/*
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n = fees.length;

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        List<int[]> []graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        pq.offer(new int[]{0, fees[0], 0}); 
        
        while(!pq.isEmpty()){
            int[] city = pq.poll();
            
            int node = city[0];
            int fee = city[1];
            int time = city[2];
            
            if(time >= minTime[node] || time > maxTime){
                continue;
            }
            
            if(node == n - 1){
                return fee;
            }
            
            minTime[node] = time;
            
            for(int[] e : graph[node]){
                int e_node = e[0];
                int e_time = time + e[1];
                int e_fee = fee + fees[e_node];
                
                pq.offer(new int[]{e_node, e_fee, e_time});
            }
        }
        
        return -1;
    }
}
*/

/*

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        List<List<int[]>> graph = new HashMap<>();
        int n = passingFees.length;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }    
    
        for(int edge[] : edged){
            int u = edge[0], 
            int v = edge[1];
            int t = edge[2];

            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        PriorityQueue<City> pq = new PriorityQueue<>((a, b) -> {
            if(a.cost == b.cost) return a.time - b.time;
            return a.cost - b.cost;
        });

        // Initialization

        pq.offer(new City(passingFees[0], 0, 0));
        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = passingFees[0]

        // Djiktra Algorithm
        while(pq.isEmpty()){
            City city = pq.poll();

            int cost = city.cost;
            int time = city.time;
            int cityNum = city.cityNum;

            if(time >= maxTime) continue;

            if(cityNum == n-1 && cost < cost_time[n-1][0]){
                cost_time[n-1][0] = cost;
            }

            for(int[] adjNode : graph.get(cityNum)){
                int v = adjNode[0];
                int t = adjNode[1];

                if(cost[v] > cost[u] + ){

                }
            }
        }

        return -1;
    }
    
    class City{
        int cost;
        int time;
        int cityNum;

        public City(int cost, int time, int cityNum){
            this.cost = cost;
            this.time = time;
            this.cityNum = cityNum;
        }
    }
}

*/