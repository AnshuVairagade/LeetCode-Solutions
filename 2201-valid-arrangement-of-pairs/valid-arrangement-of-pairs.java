/*
Why Euler??
Where to start?? 
Edge Cases >>> (EG, SEG, NEG)

Graph Building ???
DFS implementation ???
When to store result ??? Why??
What to return 

Why previous linkedlist gave me TLE??

*/

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, PriorityQueue<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>(); 
        // (out - in) degree map

        for(int[] pair : pairs){
            graph.putIfAbsent(pair[0], new PriorityQueue<>());
            graph.get(pair[0]).offer(pair[1]);
            degree.put(pair[0], degree.getOrDefault(pair[0], 0)+1);
            degree.put(pair[1], degree.getOrDefault(pair[1], 0)-1);
        }

        int src = -1, temp = 0;
        for(int node : degree.keySet()){
            if(degree.get(node) == 1){
                src = node;
                break;
            }
            temp = node; // start from the any node -> Example 2
        }

        if(src == -1) src = temp;

        List<Integer> res = new ArrayList<>();
        dfs(src, graph, res);

        Collections.reverse(res);

        int ans[][] = new int[res.size()-1][2];
        for(int i=1; i<res.size(); i++){
            ans[i-1][0] = res.get(i-1);
            ans[i-1][1] = res.get(i);
        }

        return ans;
    }   

    private void dfs(int node, HashMap<Integer, PriorityQueue<Integer>> graph, List<Integer> res){

        PriorityQueue<Integer> adj = graph.getOrDefault(node, null);
        while(adj != null && !adj.isEmpty()){
            dfs(adj.poll(), graph, res);
        }

        res.add(node);
    }
}




/*
 Using ArrayList

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>() // (out - in) degree

        for(int[] pair : pairs){
            graph.putIfAbsent(pair[0], new ArrayList<>());
            graph.get(pair[0]).add(pair[1]);
            degree.get(pair[0], map.getOrDefault(pair[0], 0)+1);
            degree.get(pair[1], map.getOrDefault(pair[1], 0)-1);
        }

        int src = -1;
        for(int node : degree.keySet()){
            if(degree.get(node) == 1){
                src = -1;
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        dfs(src, graph, res);


    }

    private void dfs(int node, HashMap<Integer, List<Integer>> graph, List<Integer> res){
        res.add(src);

        while(graph.containsKey(node) && !graph.get(node).isEmpty()){
            dfs(graph.get(node).get(0), )
        }
    }
}

*/

