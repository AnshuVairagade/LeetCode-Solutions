// It is always better to use pair for representing node stored in PriorityQueue than int[] array as we need to typecast in such questions

import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double dis[] = new double[n];
        List<List<double[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            double prb = succProb[i];
            graph.get(u).add(new double[]{v, prb});
            graph.get(v).add(new double[]{u, prb});
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));
        pq.add(new double[]{start_node, 1.0});
        dis[start_node] = 1.0;
        
        while(!pq.isEmpty()){
            double node[] = pq.poll();
            int u = (int)node[0];
            double prb_u = node[1];

            if(prb_u < dis[u]) continue;
            if(u == end_node) return prb_u;

            for(double[] adjNode : graph.get(u)){
                int v = (int)adjNode[0]; 
                double prb_v = adjNode[1];

                double n_prb = prb_u * prb_v;
                if(n_prb > dis[v]){
                    dis[v] = n_prb;
                    pq.add(new double[]{v, n_prb});
                }
            }
        }

        return 0.0;
    }
}