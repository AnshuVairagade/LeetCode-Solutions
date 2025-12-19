class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node, Node> map = new HashMap<>();
        
        Node root = new Node(node.val);
        map.put(node, root);

        build(node, map);

        return root;
    }

    private void build(Node node, HashMap<Node, Node> map){
        Node root = map.get(node);

        for(Node u : node.neighbors){
            boolean flag = false;
            if(map.getOrDefault(u,null) == null){
                map.put(u, new Node(u.val));
                flag = true;
            }
            root.neighbors.add(map.get(u));
            if(flag) build(u, map);
        }
    }
}



/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


