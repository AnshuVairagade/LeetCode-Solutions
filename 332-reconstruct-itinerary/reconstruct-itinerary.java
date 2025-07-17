// optimized DFS problem

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, LinkedList<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            graph.putIfAbsent(src, new LinkedList<>());
            graph.get(src).add(dest);
        }

        graph.keySet().forEach(node -> {
            Collections.sort(graph.get(node));
        });

        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", ans, graph);
        return ans;
    }

    private void dfs(String src, LinkedList<String> ans, HashMap<String, LinkedList<String>> graph){

        // Source with no adjacent first add to ans then return  
        if(graph.containsKey(src) == false){
            ans.addFirst(src); return;
        }

        LinkedList<String> ngb = graph.get(src);
        while(ngb.size() > 0){
            String dest = ngb.pollFirst();
            dfs(dest, ans, graph);
        }

        ans.addFirst(src);
    }
}

/* Learning : Upadted dfs traversal to visit nodes in lexicograhical order covering all the edges which different than traversing unvisited node in standard DFS template
*/