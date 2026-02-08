// Doc given below

class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<String> set = new HashSet<>();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : connections){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            set.add(edge[0]+","+edge[1]);
        }

        int vis[] = new int[n];
        return dfs(0, graph, vis, set);
    }

    private int dfs(int node, List<List<Integer>> graph, int vis[], HashSet<String> set){
        vis[node] = 1;

        int cnt = 0;
        for(int adjNode : graph.get(node)){
            if(vis[adjNode] == 1) continue;

            String edge = adjNode+","+node;
            if(!set.contains(edge)) cnt++;
            cnt += dfs(adjNode, graph, vis, set);
        }

        return cnt;
    }
}


/*
Trap : With DAG condition I thought topo sort, tried way like starting from the indegree or outdegree node ( 0 or 1) but it does not hold here

Solution : Build the undirected graph and for every possible adjacent node check whether edge exist or not during the DFS.

TC = O(N)
SC = O(N) + O(N+E) + O(N)
     set    graph    vis
*/