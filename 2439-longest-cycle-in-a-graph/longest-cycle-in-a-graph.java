// Hint  : by using Topo Sort we can islolate the cycles

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;

        HashMap<Integer, Integer> graph = new HashMap<>();
        int indegree[] = new int[n];

        for(int i=0; i<n; i++){
            if(edges[i] == -1) continue;

            indegree[edges[i]]++;
            graph.putIfAbsent(i, edges[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();

            int adjNode = graph.getOrDefault(node, -1);
            if(adjNode == -1) continue;
            indegree[adjNode]--;
                
            if(indegree[adjNode] == 0){
                queue.offer(adjNode);
            }
        }

        int vis[] = new int[n];
        int longestCycle = -1;

        for(int i=0; i<n; i++){
            if(indegree[i] == 0 || vis[i] == 1) continue;

            int cycle = normal_dfs(i, graph, vis);
            longestCycle = Math.max(longestCycle, cycle);
        }

        return longestCycle;
    }


    private int normal_dfs(int node, HashMap<Integer, Integer> graph, int[] vis){
        if(vis[node] == 1){
            return 0;
        }

        vis[node] = 1;
        int adjNode = graph.get(node);

        // int cnt = 1;
        // for(int adjNode : graph.get(node)){
        //     normal_dfs(adjNode, graph, vis);
        // }

        return 1 + normal_dfs(adjNode, graph, vis);
    }


}