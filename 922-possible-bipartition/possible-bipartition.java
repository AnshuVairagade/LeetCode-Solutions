// Intuition : Think of problem like bipartation of graph two dislinking people have different choice of colors.

// Approach : BFS on Acyclic graph with adjacency list 

// Edge case : Disconneted graph with mutiple components.

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int vis[] = new int[n+1];
        int color[] = new int[n+1]; // -1 -> red & 1 ->black
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());
        for(int pair[] : dislikes){
            int u = pair[0], v = pair[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0; i<=n; i++){
            if(vis[i] == 0 && coloringBFS(graph, i, color, vis) == false) return false;
        }
        return true;
    }

    private boolean coloringBFS(List<List<Integer>> graph, int src, int color[], int vis[]){
        Queue<Integer> que = new LinkedList<>();
        que.offer(src);
        color[src] = 1;
        vis[src] = 1;
        while(!que.isEmpty()){
            int node = que.poll();
            vis[node] = 1;

            for(int adjNode : graph.get(node)){
                if(color[adjNode] == color[node]){
                    return false;
                }

                if(vis[adjNode] == 0){
                    color[adjNode] = color[node] == 1 ? -1 : 1;
                    que.offer(adjNode);
                }
            }
        }
        return true;
    }
}