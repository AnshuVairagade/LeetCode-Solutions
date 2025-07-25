class Solution {
    int mod = 1000000007;
    
    public int countPaths(int n, int[][] roads) {
        // Bulding the graph
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int edge[] : roads){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int ways[] = new int[n];
        long dist[] = new long[n];
        ways[0] = 1;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        while(!pq.isEmpty()){
            long node[] = pq.poll();
            int u = (int)node[1];
            long k = node[0];
            
            if(k > dist[u]) continue;

            for(int[] adjNode : graph.get(u)){
                int v = adjNode[0];
                int w = adjNode[1];

                if(dist[v] > dist[u]+w){
                    ways[v] = ways[u];
                    dist[v] = dist[u]+w;
                    pq.add(new long[]{dist[v], v});
                }
                else if(dist[v] == dist[u]+w){
                    ways[v] = (ways[v]+ways[u])%mod;
                }
            }
        }
        return ways[n-1];
    }
}