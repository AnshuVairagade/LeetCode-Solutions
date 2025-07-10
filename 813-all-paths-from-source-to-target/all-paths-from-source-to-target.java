class Solution {
    private void dfs(int node, int v, int[][] graph, List<Integer> ds, List<List<Integer>> ans){
        ds.add(node);
        if(node == v) ans.add(new ArrayList(ds));
        
        for(int adjNode : graph[node]){
            dfs(adjNode, v, graph, ds, ans);
        }

        ds.remove(ds.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int v = graph.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        dfs(0, v, graph, ds, ans);
        return ans;
    }
}


// class Solution {
//     private void dfs(int node, int v, int[][] graph, List<Integer> ds, List<List<Integer>> ans, int vis[]){
//         if(node != v) vis[node] = 1;
//         ds.add(node);
//         if(node == v) ans.add(new ArrayList(ds));
        
//         for(int adjNode : graph[node]){
//             if(vis[adjNode] == 0) dfs(adjNode, v, graph, ds, ans, vis);
//         }

//         ds.remove(ds.size()-1);
//         vis[node] = 0;
//     }

//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         int v = graph.length-1;
//         int vis[] = new int[v+1];
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         dfs(0, v, graph, ds, ans, vis);
//         return ans;
//     }
// }