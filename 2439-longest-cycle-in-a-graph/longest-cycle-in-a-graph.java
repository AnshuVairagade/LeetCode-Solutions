// Intuition : Famous Algorithm for SCC

class Solution {
    Stack<Integer> st = new Stack<>();

    public int longestCycle(int[] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> revGraph = new ArrayList<>();
        int n = edges.length;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            if(edges[i] == -1) continue;

            graph.get(i).add(edges[i]);
            revGraph.get(edges[i]).add(i);
        }

        int vis[] = new int[n];
        for(int i=0; i<n; i++){
            if(vis[i] == 1) continue;
            normal_dfs(i, graph, vis);
        }

        int longestCycle = -1;
        int vis2[] = new int[n];
        while(!st.empty()){
            int node = st.peek(); st.pop();
            
            if(vis2[node] == 1) continue;
            
            int cycle = time_based_dfs(node, revGraph, vis2);
            longestCycle = Math.max(cycle, longestCycle);
        }

        return longestCycle == 1 ? -1 : longestCycle;
    }

    private int time_based_dfs(int node, List<List<Integer>> revGraph, int[] vis2){
        if(vis2[node] == 1){
            return 0;
        }

        vis2[node] = 1;

        int cnt = 1;
        for(int adjNode : revGraph.get(node)){
            cnt += time_based_dfs(adjNode, revGraph, vis2);
        }

        return cnt;
    }

    private void normal_dfs(int node, List<List<Integer>> graph, int[] vis){
        if(vis[node] == 1){
            return;
        }

        vis[node] = 1;

        for(int adjNode : graph.get(node)){
            normal_dfs(adjNode, graph, vis);
        }

        st.push(node);
    }


}